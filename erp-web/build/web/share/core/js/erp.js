/*Ham thuc hien reload datagrid. 
 * Cac tham so:
 * URL: URL de thuc hien lay du lieu phia server
 * jq_grid la doi tuong jquery data grid tra ve tu ham khoi tao grid: $("selector").pqGrid(...)
 * param: cac tham so truyen len server cung voi URL de thuc hien tim kiem.Param duoi dang json
 *  Vi du:
 * //        var param = {};
 //        param.name = $("#name").val();
 //        param.description = $("#description").val();
 //        return {url: "searchProfitCenter.json", data: param};
 */

var vt_datagrid = {
    buildGridCheckBox: function (selector, url, datafields, columns, settings, param) {
        // prepare the data
        var source =
                {
                    datatype: "json",
                    datafields: datafields,
                    url: url,
                    cache: false,
                    beforeprocessing: function (data) {
                        source.totalrecords = data.totalRecords;
                    },
                    filter: function () {
                        // update the grid and send a request to the server.
                        $(selector).jqxGrid('updatebounddata', 'filter');
                    },
                    sort: function () {
                        // update the grid and send a request to the server.
                        $(selector).jqxGrid('updatebounddata', 'sort');
                    }
                };
        if (arguments.length > 5) {
            source.data = param;//Truyen them tham so
        }
        var dataAdapter = new $.jqx.dataAdapter(source);
        var defaultSetting = {
            width: '100%',
            height: '100%',
      		showfilterrow: true,
            filterable: true,
            source: dataAdapter,
            sortable: true,
            pageable: true,
            pagesize: 10,
            autoheight: true,
            columnsresize: true,
            selectionmode: 'checkbox',
            virtualmode: true, //Thuoc tinh qui dinh grid phan trang tung phan phia server
            rendergridrows: function () {
                return dataAdapter.records;
            },
            columns: columns
        };
        if (arguments.length > 4) {
            jQuery.extend(defaultSetting, settings);
        }
        $(selector).jqxGrid(defaultSetting);
    },
    reload: function (selector, adapter, param) {
        var source = {};
        if (arguments.length > 1) {
            source = adapter;
        } else {
            source = $(selector).jqxGrid("source");
        }
        if (arguments.length > 2) {
            
            source._source.data = param;//Truyen them tham so
        }

        $(selector).jqxGrid({source: source});
    },
    //Ham lay doi tuong row tra ve duoi dang json dua vao rowIndxPage tinh tu 0 - ..10000   
    getRowByIndx: function (selector, rowIndxPage) {
        return $(selector).jqxGrid('getrowdata', rowIndxPage);
    },
    //Ham lay doi tuong row tra ve duoi dang json dua vao rowIndxPage tinh tu 0- ..10000   
    getRowsSelection: function (selector) {
        var arrRowIndSelected = $(selector).jqxGrid('getselectedrowindexes');
        var result = new Array();
        for (i = 0; i < arrRowIndSelected.length; i++) {
            result.push(vt_datagrid.getRowByIndx(selector, arrRowIndSelected[i]));
        }
        return result;
    },
    //Ham lay doi tuong row tra ve duoi dang json  
    getLastRowSelected: function (selector) {
        var rowIndxPage = $(selector).jqxGrid('getselectedrowindex');
        return vt_datagrid.getRowByIndx(selector, rowIndxPage);
    },
    //Ham kiem tra xem co row nao duoc chon khong, tra ve so luong hang duoc chon.Neu khong co hang nao 
    //duoc chon thi tra ve 0.
    getTotalRowSelected: function (selector) {
        return $(selector).jqxGrid('getselectedrowindexes').length;
    },
    getRowPerPage: function (selector) {
        return $(selector).jqxGrid('pagesize');
    },
    //Ham tra lai tat ca cac input trong form duoi dang param tren URL
    //VD: a=fdas&b=gfsg&...
    getFormAsParamUrl: function (frmSelector) {
        return $(frmSelector).serialize();
    },
    //Ham tra lai tat ca cac input trong form duoi dang param tren URL
    //VD: a=fdas&b=gfsg&...
    getFormAsObj: function (frmSelector) {
        var arrObj = $(frmSelector).serializeArray();
        var param = {};
        for (i = 0; i < arrObj.length; i++) {
            param[arrObj[i].name] = arrObj[i].value;
        }
        return param;//tra lai doi tuong json chua cac input theo key:value
    },
    addConfigGrid: function (gridSelector, configSelector) {
        var container = $(configSelector);
        var table = $('<table/>').addClass('table');
        //
        var thRow = $('<tr></tr>');
        var thLabel = $('<th/>').text('Cột');
        var thChkBoxFrz = $('<th/>').text('Frezee');
        var thchkBoxSho = $('<th/>').text('Ẩn hiện');
        thRow.append(thLabel).append(thChkBoxFrz).append(thchkBoxSho);
        table.append(thRow);
        //
        var cols = $(gridSelector).pqGrid("option", "colModel");
        var chkBoxFrzArr = [];
        for (var i = 0; i < cols.length; i++) {
            var col = cols[i];
            var label = $('<label />', {for : 'col_' + col.dataIndx});
            label.html(col.title);
            var chkBoxFrz = $('<input />', {type: 'checkbox', id: 'frez_' + col.dataIndx, value: i});
            var chkBoxSho = $('<input />', {type: 'checkbox', id: 'show_' + col.dataIndx, value: i});
            chkBoxFrzArr.push(chkBoxFrz);
            chkBoxFrz.click(function () {
                if ($(this).is(":checked"))
                {
                    chkBoxFrzArr.forEach(function (cbk) {
                        cbk.prop('checked', false);
                    });
                    $(this).prop('checked', true);
                    $(gridSelector).pqGrid("option", "freezeCols", $(this).val());
                } else {
                    $(gridSelector).pqGrid("option", "freezeCols", 0);
                }
                $(gridSelector).pqGrid("refresh");
            });
            chkBoxSho.click(function () {
                var colM = $(gridSelector).pqGrid("option", "colModel");
                var idx = $(this).val();
                if ($(this).is(":checked"))
                {
                    // hide col
                    colM[idx].hidden = true;
                } else {
                    // show col
                    colM[idx].hidden = false;
                }
                $(gridSelector).pqGrid("option", "colModel", colM);
            });
            // 
            var row = $('<tr></tr>');
            var tdName = $('<td></td>').append(label);
            var tdChkBoxFrz = $('<td></td>').append(chkBoxFrz);
            var tdChkBoxSho = $('<td></td>').append(chkBoxSho);
            row.append(tdName).append(tdChkBoxFrz).append(tdChkBoxSho);
            table.append(row);
        }
        table.appendTo(container);

        // 
        var config = $(configSelector).dialog({
            autoOpen: false,
            height: 300,
            width: 700,
            modal: true,
            buttons: {
                "OK": function () {
                    config.dialog("close");
                }
            },
            close: function () {
            }
        });
        return config;
    },
    // create button on toolbar
    createButton: function (name) {
        var args = arguments;
        var _name = name;
        var _onClick = function (evt) {

        };
        var _icon = 'ui-icon-document';
        if (args.length >= 2) {
            if (args[1] !== null)
            {
                _onClick = args[1];
            }
            if (args.length >= 3) {
                _icon = args[2];

            }
        }
        var btn = {
            type: 'button',
            label: _name,
            icon: _icon,
            listeners: [{
                    "click": function (evt) {
                        _onClick(evt);
                    }
                }]
        }
        return btn;

    }

};
var vt_alert = {
    showAlert: function (msg) {
        var options = {};
        var width = ($(".body").innerWidth() - 240) / 2;
        // run the effect
        $("#message").css("left", width);
        if (arguments.length === 0)//Neu ham truyen vao du 1 tham so
        {
            $("#contentMsg").text(VT_GLOBAL_VAR.successContent);
        } else if (arguments.length === 1) {
            $("#contentMsg").text(msg);
        }
        $("#message").show("clip", options, 500, vt_alert.callback);
    },
    callback: function () {
        setTimeout(function () {
            $("#message:visible").removeAttr("style").fadeOut();
        }, 3000); //an sau 1s
    },
    showNotify: function (msg, settings) {
        var defaultSetting = {width: "auto", position: "bottom-right",
            opacity: 0.9, autoOpen: false, autoClose: true, template: "info"
        };
        if (arguments.length === 0)//Neu ham truyen vao du 1 tham so
        {
            $("#jqxNotification").html(VT_GLOBAL_VAR.successContent);
        } else if (arguments.length > 0) {
            $("#jqxNotification").html(msg);
            if (arguments.length > 1) {
                jQuery.extend(defaultSetting, settings);
            }
        }
        $("#jqxNotification").jqxNotification(defaultSetting);
        $("#jqxNotification").jqxNotification("open");
    }
};
var vt_form = {
    validate: function (selector, rule) {
        rule["errorPlacement"] = function (error, element) {
            // show message
            vt_alert.showAlert(error.text());
            // focus on error element
            element.focus();
        };
        $(selector).validate(rule);
        return $(selector).valid();
    },
    ajax: function (type, url) {
        var _type, /*type = POST, GET, DELETE */
                _url, /* */
                _param, /*data param use for req*/
                _formId,
                _area,
                _onDone, _onFail, _onAlway, _async;
        var args = arguments;
        _param = null;
        _formId = null;
        _type = args[0];
        _url = args[1];
        _onAlway = function () {};
        _onFail = function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        };
        var _onDefault;

        if (args.length >= 3) {
            _param = args[2];
            if (args.length >= 4) {
                _formId = args[3];
                if (args.length >= 5) {
                    _area = args[4];
                }
                if (args.length >= 6) {
                    _onDone = args[5];
                    if (args.length >= 7) {
                        _onFail = args[6];
                        if (args.length >= 8) {
                            _onAlway = args[7];
                            if (args.length >= 9) {
                                _async = args[8];
                            }
                        }
                    }
                }
            }
        }
        if (_formId) {
            var $inputs = $(_formId).find("input, select, button, textarea");
            _param = $(_formId).serialize();            
            $inputs.prop("disabled", true);
            _onDefault = function () {
                try {
                    var $inputs = $(_formId).find("input, select, button, textarea");
                    $inputs.prop("disabled", false);
                } catch (e)
                {
                    console.log(e);
                }
            }
        }

        $.ajax({
            traditional: true,
            url: url,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("X-XSRF-TOKEN", $('input[name=_csrf]').val());
            },
            data: _param,
            dataType: "text",
            type: type,
        }).success(function (result) {            
            _onDone(jQuery.parseJSON(result));
        }).fail(function (jqXHR, textStatus, errorThrown) {
            // show error message
            _onFail(jqXHR, textStatus, errorThrown);
        }).always(function () {
            _onAlway();
            if (_formId) {
                _onDefault();
            }
        });

    },
    get: function (url) {
        var _url, _data, _onDone, _dataType;
        var args = arguments;
        _param = null;
        _form = null;
        _responseType = "text";
        _url = args[0];
        $.ajax({
            traditional: true,
            url: url,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("X-XSRF-TOKEN", $('input[name=_csrf]').val());
            },
            data: data,
            dataType: "text",
            type: type,
            success: function (result) {
                onDone(jQuery.parseJSON(result));
            },
            fail: function (jqXHR, textStatus, errorThrown) {
                // show error message
                console.log(textStatus);
            }
        });

    },
    updateArea: function (selector, url, data, callback) {
        var _data = {};
        if (arguments.length > 2 && data !== null) {
            _data = data;
        }
        $.ajax({
            traditional: true,
            url: url,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("X-XSRF-TOKEN", $('input[name=_csrf]').val());
            },
            data: _data,
            dataType: "html",
            success: function (result) {
                $(selector).html(result);
                if (arguments.length > 3) {
                    callback(result);
                }
            },
            fail: function (jqXHR, textStatus, errorThrown) {
                // show error message
                console.log(textStatus);
            }
        });
    }
};
var vt_control = {
    //Ham tao ra control autocomplete
    buildAutoComplete: function (selector, url, setting, param, onChange) {
        //initialize the pqSelect widget.

        var defaultSetting = {multiSelect: true, width: "100%"
            , displayMember: "label", valueMember: "value", remoteAutoComplete: false};
        jQuery.extend(defaultSetting, setting);
        if (defaultSetting.remoteAutoComplete === true) {//neu la truong hop remote
            defaultSetting.search = function (searchString) {
                dataAdapter.dataBind();
            };
        }
        var source =
                {
                    datatype: "json",
                    datafields: [
                        {name: 'label'},
                        {name: 'value'},
                        {name: 'desc'}
                    ],
                    data: param,
                    url: url,
                    async: false
                };
        var dataAdapter = new $.jqx.dataAdapter(source, {
            formatData: function (data) {
                if ($(selector).jqxComboBox('searchString') !== undefined) {
                    data.keysearch = $(selector).jqxComboBox('searchString');
                    return data;
                }
            }
        });
        defaultSetting.source = dataAdapter;
        // Create a jqxComboBox
        $(selector).jqxInput(defaultSetting);    
        // trigger selection changes.
        if (arguments.length > 4) {
            $(selector).on('change', function (event) {
                var items = $(selector).jqxComboBox('getSelectedItems');
//                var selectedItems = "";
//                $.each(items, function (index) {
//                    selectedItems += this.value;
//                    if (items.length - 1 !== index) {
//                        selectedItems += ",";
//                    }
//                });
                if (items) {
                    onChange(items);
                }
            });
        }
    },
    //tree nay se thuc hien load toan bo du lieu ra mot luc
    buildTree: function (selector, url, param, setting, onSelect) {
        var defaultSetting = {height: '300px', width: '200px', checkboxes: true};
        jQuery.extend(defaultSetting, setting);
        $.getJSON(url, param, function (result) {
            defaultSetting.source = result;
            $(selector).jqxTree(defaultSetting);
        });

        $(selector).bind('select', function (event) {
            var args = event.args;
            var item = $(selector).jqxTree('getItem', args.element);
//            console.log(item);
            if (arguments.length > 4) {
                onSelect(item);
            }
        });

    },
    //tree nay se thuc hien load node cap 1, sau do click vao den dau thi load den day
    buildTreeLazy: function (selector, url, param, setting, onSelect) {
        // Create jqxTree
        var defaultSetting = {height: '300px', width: '100%', checkboxes: true};
        jQuery.extend(defaultSetting, setting);
        var tree = $(selector);
        var source = null;
        $.ajax({
            async: false,
            url: url,
            data: param,
            success: function (data, status, xhr) {
//                console.log(data);
                source = data;
            }
        });
        defaultSetting.source = source;
        tree.jqxTree(defaultSetting);
        tree.on('expand', function (event) {
            var label = tree.jqxTree('getItem', event.args.element).label;
            var $element = $(event.args.element);
            var loader = false;
            var loaderItem = null;
            var children = $element.find('ul:first').children();
            $.each(children, function () {
                var item = tree.jqxTree('getItem', this);
                if (item && item.label === 'Loading...') {
                    loaderItem = item;
                    loader = true;
                    return false;
                }
            });
            if (loader) {
//                console.log("loaderItem");
//                console.log(loaderItem);
                var urlChild = "";
                if (url.indexOf("?") !== -1) {
                    urlChild = url + "&&parentValue=" + loaderItem.value;
                } else {
                    urlChild = url + "?parentValue=" + loaderItem.value;
                }
                $.ajax({
                    url: urlChild,
                    data: param,
                    success: function (data, status, xhr) {
                        var items = data;
                        tree.jqxTree('addTo', items, $element[0]);
                        tree.jqxTree('removeItem', loaderItem.element);
                    }
                });
            }
        });
        if (arguments.length > 4) {
            $(selector).bind('select', function (event) {
                var args = event.args;
                var item = $(selector).jqxTree('getItem', args.element);
                onSelect(item);
            });
        }
    },
    //tree nay se thuc hien load node cap 1, sau do click vao den dau thi load den day
    buildListBox: function (selector, url, setting, onSelect) {
        var defaultSetting = {displayMember: "label", valueMember: "value"
            , width: "100%", height: 200, multiple: true};
        jQuery.extend(defaultSetting, setting);
        var source =
                {
                    datatype: "json",
                    datafields: [
                        {name: 'label'},
                        {name: 'value'}
                    ],
                    id: 'id',
                    url: url
                };

        var dataAdapter = new $.jqx.dataAdapter(source);
        defaultSetting.source = dataAdapter;
        // Create a jqxListBox
        $(selector).jqxListBox(defaultSetting);
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
    buldToolTip: function (selector, content) {
        $(selector).jqxTooltip({position: 'top', content: content});
    },
    buildTab: function (selector, setting) {
        var defaultSetting = {width: "100%", height: "100%", showCloseButtons: true};
        if (arguments.length > 1) {
            jQuery.extend(defaultSetting, setting);
        }
        $(selector).jqxTabs(defaultSetting);
    }
    
   

    //buildTextAutoComplete:function(selector)
};
var vt_util = {
    split: function (val) {
        return val.split(/,\s*/);
    },
    extractLast: function (term) {
        return vt_util.split(term).pop();
    }, load2Tab: function (selector, url, tabIndex) {
        $.get(url, function (data) {              
            $(selector).jqxTabs('setContentAt', tabIndex, data); 
        });
    }, load2LastTab: function (selector, url) {
        $.get(url, function (data) {
            var tabIndex = $(selector).jqxTabs('length'); 
            
            $(selector).jqxTabs('setContentAt', tabIndex -1, data); 
        });
    }
};

var vt_dialog = {
    buildDialog: function (selector, settings, onOpen, onClose) {
        var defaultSetting = {width: '100%', height: '100%', autoOpen: false,
            resizable: true, showCollapseButton: true, draggable: true};
        jQuery.extend(defaultSetting, settings);
        $(selector).jqxWindow(defaultSetting);
        if (arguments.length > 2) {
            $(selector).on('open', function (event) {
                onOpen.call();
            });
            if (arguments.length > 3) {
                $(selector).on('close', function (event) {
                    onClose.call();
                });
            }
        }
    },
    open: function (selector) {
        $(selector).jqxWindow('open');
    },
    close: function (selector) {
        $(selector).jqxWindow('close');
    }
};