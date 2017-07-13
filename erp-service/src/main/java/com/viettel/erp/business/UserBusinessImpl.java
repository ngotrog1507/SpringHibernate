package com.viettel.erp.business;

import com.viettel.erp.dao.UserDAO;
import com.viettel.erp.dto.ActIdUserDTO;
import com.viettel.erp.bo.ActIdUserBO;
import com.viettel.erp.ignite.base.BusinessBean;
import com.viettel.erp.ignite.base.DataBean;
import com.viettel.erp.ignite.base.MapReduceBean;
import com.viettel.erp.ignite.base.VtComputeTaskAdapter;
import com.viettel.erp.ignite.base.VtIgniteCallable;
import com.viettel.erp.ignite.base.VtIgniteClosure;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.IgniteException;
import org.apache.ignite.IgniteIllegalStateException;
import org.apache.ignite.Ignition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("userBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserBusinessImpl extends BaseFWBusinessImpl<UserDAO, ActIdUserDTO, ActIdUserBO> implements UserBusiness {

    @Autowired
    private UserDAO userDAO;
    

     
    public UserBusinessImpl() {
        tModel = new ActIdUserBO();
        tDAO = userDAO;
    }

    @Override
    public UserDAO gettDAO() {
        return userDAO;
    }

    @Override
    public long getUserCount() {
        
        return userDAO.count("ActIdUser", null);
    }

//    @Override
//    public Integer wordCount(String wordStr) {
//        List<String> ls = Arrays.asList(wordStr.split(" "));
//        return wordCount4(ls);
//    }

    /**
     * apply Closure for compute
     *
     * @param ls
     * @return
     */
    public Integer wordCount1(List<String> ls) {
        int sum = 0;
        try {
            // Get compute from remote node
            IgniteCompute compute = Ignition.ignite().compute();

            // Transform data in original list to DataBean list
            List<DataBean> lsBean = new ArrayList<>();
            for (String str : ls) {
                lsBean.add(new DataBean(str));
            }
            // Create business bean
            BusinessBean bizBean = new BusinessBean("com.viettel.erp.ignite.UserIgniteClosure", "countWord", new Class[]{String.class});

            // Create object reference to business class 
            VtIgniteClosure cus = new VtIgniteClosure(bizBean);

            // Assign data in list to nodes and compute
            Collection<Object> res = compute.apply(cus, lsBean);

            // Implement reduce result
            for (Object len : res) {
                sum += (Integer) len;
            }
            // Print result to console
            System.out.println("hunglq9 test apply countWord: sum =" + sum);
        } catch (IgniteIllegalStateException | IgniteException ex) {
            ex.printStackTrace();
        }
        return sum;
    }
//
//    /**
//     *
//     * @param ls
//     * @return
//     */
    public Integer wordCount2(List<String> ls) {
        int sum = 0;
        try {
            // Get compute from remote node
            IgniteCompute compute = Ignition.ignite().compute(getRemoteNodeGroup());
            // Create business bean
            BusinessBean bizBean = new BusinessBean("com.viettel.erp.ignite.UserIgniteClosure", "countWord", new Class[]{String.class});

            // Create callable job
            Collection<VtIgniteCallable> calls = new ArrayList<>();
            for (String str : ls) {
                calls.add(new VtIgniteCallable(bizBean, new DataBean(str)));
            }
            // Execute collection of callables on the cluster.
            Collection<Object> res1 = compute.call(calls);

            // Implement reduce result
            for (Object i1 : res1) {
                sum += (Integer) i1;
            }
            // Print result to console
            System.out.println("hunglq9 test call and run countWord:  total =" + sum);
        } catch (IgniteIllegalStateException | IgniteException ex) {
            ex.printStackTrace();
        }
        return sum;
    }
//
//    /**
//     *
//     * @param ls
//     * @return
//     */
    public Integer wordCount3(List<String> ls) {
        int sum = 0;
        try {
            // Get executor from remote node
            ExecutorService exec = Ignition.ignite().executorService(getRemoteNodeGroup());
            // Create business bean
            BusinessBean bizBean = new BusinessBean("com.viettel.erp.ignite.UserIgniteClosure", "countWord", new Class[]{String.class});

            // Iterate through all words in the sentence and create jobs.
            List<Future> lsF = new ArrayList<>();
            for (final String word : ls) {
                // Execute runnable on some node.
                lsF.add(exec.submit(new VtIgniteCallable(bizBean, new DataBean(word))));
            }

            // Implement reduce result
            for (Future f : lsF) {
                sum += (Integer) f.get();
            }

            // Print result to console
            System.out.println("hunglq9 test ExecutorService countWord : " + sum);
        } catch (IgniteIllegalStateException | InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        return sum;
    }
//
//    /**
//     * MapReduce
//     *
//     * @param ls
//     * @return
//     */
    public Integer wordCount4(List<String> ls) {
        int sum = 0;
        try {
            // Get compute from remote node
            IgniteCompute compute = Ignition.ignite().compute(getLocalNodeGroup());
            // Create business bean + Create map bean 
            BusinessBean bizBean = new BusinessBean("com.viettel.erp.ignite.UserIgniteClosure", "subprocess", new Class[]{String.class});
            MapReduceBean mrdBean = new MapReduceBean("com.viettel.erp.ignite.UserIgniteClosure", "hamchia");
            // 
            VtComputeTaskAdapter adt = new VtComputeTaskAdapter(bizBean, mrdBean);
            Object cnt = compute.execute(adt, ls);

            // Implement reduce result
            List<Integer> lsInt = (List<Integer>) cnt;
            for (Integer i1 : lsInt) {
                sum += i1;
            }
            System.out.println("hunglq9 test MapReduce: " + sum);
        } catch (IgniteIllegalStateException | IgniteException ex) {
            ex.printStackTrace();
        }
        return sum;
    }

}
