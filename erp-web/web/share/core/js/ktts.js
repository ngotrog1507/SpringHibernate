/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var ktts_control={
     defaultHeight: '34px',     
     buildGrid:function (selector, url, datafields, columns, settings, param){
         var defaultSetting={
           filterable: false,
           sortable:false,
           selectionmode:'singlerow',
           	showfilterrow: false
         };
             console.log(defaultSetting);
        if (arguments.length > 4) {
          jQuery.extend(defaultSetting, settings);
        }
    
        vt_datagrid.buildGridCheckBox(selector, url, datafields, columns, defaultSetting, param);
     },     
    //build default comboBox
     buildComboBox: function (selector, url, setting, onSelect) {
        var defaultSetting = {displayMember: "label", 
            valueMember: "value" ,
            selectedIndex: 0,
            width:$(selector).width(),
            height:$(selector).height()
           };
           
        jQuery.extend(defaultSetting, setting);
        var source =
                {
                    datatype: "json",
                    datafdatatypeields: [
                        {name: 'label'},
                        {name: 'value'}
                    ],
                    
                    id: 'id',
                    url: url
                };

        var dataAdapter = new $.jqx.dataAdapter(source);
        
        defaultSetting.source = dataAdapter;
        
        // Create a jqxcomboBox
        $(selector).jqxComboBox(defaultSetting);
        if (arguments.length > 3) {
            $(selector).bind('select', function (event) {
                if (event.args) {
                    var item = event.args.item;
                    if (item) {
                        onSelect(item);
                    }
                }
            });
        }
    },
    
    //build datapicker
    buildDateTimePicker:function(selector,setting){
        var defaultSetting={ width: '100%', height:this.defaultHeight};
        jQuery.extend(defaultSetting, setting);
         $(selector).jqxDateTimeInput(defaultSetting);
    },
    
    buildAutoComple: function(selector,setting){
        var defaultSetting={ placeHolder:'Auto Complete',
            displayMember:'label',
            valueMember:'value',
            height:this.defaultHeight,
            width:'100%'
    };
    }
    
};
var ktts_util={
    gotoMenu: function(href,selector,index){        
        vt_util.load2Tab("#jqxTabs", href,$("#jqxTabs").jqxTabs('length')-1);
    },
    extendMenu:function(href){
         $('#jqxTabs').jqxTabs('addLast', '', ''); 
         vt_util.load2Tab("#jqxTabs", href,$("#jqxTabs").jqxTabs('length')-1);
    }
    
};


