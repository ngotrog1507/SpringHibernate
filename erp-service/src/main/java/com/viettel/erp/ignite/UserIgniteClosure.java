/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.ignite;

import com.viettel.erp.ignite.base.BusinessBean;
import com.viettel.erp.ignite.base.DataBean;
import com.viettel.erp.ignite.base.VtComputeJobAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.ignite.IgniteException;
import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.compute.ComputeJob;

/**
 *
 * @author HungLQ9
 */
public class UserIgniteClosure {

    public Integer countWord(String str) {
        // TODO here
        System.out.println("process: " + str);
        return str.length();
    }

    public List<Character> toUpperChar(String str) {
        // TODO here
        System.out.println("process: " + str);
        char[] ar = str.toUpperCase().toCharArray();
        List<Character> ls = new ArrayList<>();
        for (int i = 0; i < ar.length; i++) {
            ls.add(ar[i]);
        }
        return ls;
    }

    public Map<? extends ComputeJob, ClusterNode> map(BusinessBean bizBean, List<ClusterNode> subgrid, List ls) throws IgniteException {
        Map<ComputeJob, ClusterNode> map = new HashMap<>(ls.size());
        Iterator<ClusterNode> it = subgrid.iterator();
        // todo 
        List subList = ls.subList(0, 0);
        // split data to specified node
        for (final Object l : ls) {
            if (!it.hasNext()) {
                it = subgrid.iterator();
            }
            //
            ClusterNode node = it.next();
            map.put(new VtComputeJobAdapter(bizBean, new DataBean(l)), node);
        }
        return map;
    }

}
