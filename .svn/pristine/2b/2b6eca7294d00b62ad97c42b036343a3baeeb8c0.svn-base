/**
 * parma.target: 目标
 *      0: 人员
 *      1: 部门
 *      2: 单位
 *      3: 部门或单位
 *      4: 人、部门或单位
 *
 * param.multiple: 多选
 *   true: 允许多选
 *  false: 单选
 *
 * param.rootId: 组织范围
 *     -2: 当前人的单位（包括部门）+其它单位（不包括部门）
 *     -1: 当前人的单位
 *      0: 全部组织
 *  other: 指定单位id
 *
 * param.includeSelf: 是否包括自己
 *   true: 包括
 *  false: 不包括
 */

function selectDialog(param, data) {
    window.__selectDialog__ = this;

    this.selfUserId = undefined; // self user id

    this.param = param;
    this.data = data;

    var url = this.param.url.substring(0, this.param.url.lastIndexOf("/"));

    this.organizationUrl = url + "/organization.jhtml";

    this.userUrl = url + "/user.jhtml";
    this.userGroupMemberUrl = url + "/userGroupMember.jhtml";

    this.findOrgUrl = url + "/findOrg.jhtml";
    this.orgGroupMemberUrl = url + "/orgGroupMember.jhtml"

    this.folderIconSkin = "folder";

    this.id = {};
    this.id.prefix = "#selectDialog-";

    this.id.selfUserId = this.id.prefix + "selfUserId";
    this.id.userName = this.id.prefix + "userName";
    this.id.userGroup = this.id.prefix + "userGroup";
    this.id.orgName = this.id.prefix + "orgName";
    this.id.orgGroup = this.id.prefix + "orgGroup";

    this.id.tree = this.id.prefix + "tree";
    this.id.left = this.id.prefix + "left";
    this.id.right = this.id.prefix + "right";

    this.id.addAll = this.id.prefix + "addAll";
    this.id.add = this.id.prefix + "add";
    this.id.del = this.id.prefix + "del";
    this.id.delAll = this.id.prefix + "delAll";
    this.id.selectedCount = this.id.prefix + "selectedCount";

    this.availData = null;

    this.userNameFilter = "";
    this.orgNameFilter = "";

    this.tree = {};
    this.zTreeObj = {};

    this.tree.expandIds = []; // expand nodes after init
    this.tree.highlightId = [null, null];
    this.clickCountDown = 0;

    this.tree.onClick = function (event, treeId, treeNode, clickFlag) {
        var dialog = window.__selectDialog__;

        if (dialog.timeoutId != undefined) {
            window.clearTimeout(dialog.timeoutId);
            dialog.timeoutId = undefined;
        }

        if (dialog.clickCountDown > 0) dialog.clickCountDown--;
        var curOrgId = treeNode.id;

        if (!treeNode.orgType) { // 当前node是部门
            if (dialog.param.target == 0 || dialog.param.target == 4) { // 获取选中部门的人员
                $.post(dialog.userUrl, $.param({
                    rootId: dialog.param.rootId,
                    name: dialog.userNameFilter,
                    orgid: curOrgId,
                    isParent: false,
                    psco: treeNode.psco
                }), function (result) {
                    var dialog = window.__selectDialog__;
                    dialog.availData = result;
                    $(dialog.id.userGroup).val("");
                    $(dialog.id.orgGroup).val("");

                    dialog.addToList(result)
                }, "json");
            } else if ($.inArray(dialog.mode(), [1, 3]) >= 0) { // 单选 选择部门
                $(dialog.id.left).empty();
                $(dialog.id.left).append($("<option>", {value: treeNode.id}).text(treeNode.name));
            }
        } else { // 当前node是单位
            if (dialog.param.target != 0 && dialog.param.multiple) {
                // detect ctrl is pressed or not
                var ctrlPressed = event.ctrlKey && false; // diabled this function
                if (ctrlPressed) {
                    // check/un-check all child nodes
                    if (treeNode.check_Child_State != -1) {
                        var b = treeNode.check_Child_State == 0 || treeNode.check_Child_State == 1;

                        $.each(treeNode.children, function (i, node) {
                            dialog.zTreeObj.checkNode(node, b, false, false);
                        });
                    }
                    return;
                }
            }

            if (dialog.param.target == 0 || dialog.param.target == 4) { // 人员都是属于部门，不直接属于单位的，人员为空
                dialog.availData = null;
                $(dialog.id.left).empty();  // 先empty，后面异步添加数据
                $(dialog.id.userGroup).val("");
                $(dialog.id.orgGroup).val("");

                var rootId = dialog.param.rootId;
                var tmpquery = "";
                if (rootId == "0") {
                    // 提交 orgid
                } else if (rootId == "-2") {
                    if (treeNode.psco == 3) {
                        dialog.zTreeObj.expandNode(treeNode, !treeNode.open, false, false);
                        return;
                    }

                    // child nodes 可能没有获得，从服务端获取当前node的child(psco=1)
                    // 提交 orgid, psco, level
                } else {
                    if (treeNode.psco == 0) {
                        // 从本地获取当前node的child(psco=1)
                        var nodes = dialog.zTreeObj.getNodesByParam("psco", 1, treeNode);
                        $.each(nodes, function (i, node) {
                            tmpquery = tmpquery + "&orgidList=" + node.id;
                        });
                        // 提交 orgidList
                    } else {
                        // 提交 orgid
                    }
                }

                if (curOrgId == "1" && !dialog.userNameFilter) return; // 不取"1"组织的用户

                // 不expand node
                $.post(dialog.userUrl,
                    $.param({
                        rootId: dialog.param.rootId,
                        name: dialog.userNameFilter,
                        orgid: curOrgId,
                        level: treeNode.level,
                        psco: treeNode.psco,
                        isParent: treeNode.orgType
                    })
                    + tmpquery, function (result) {
                        var dialog = window.__selectDialog__;
                        dialog.availData = result;

                        dialog.addToList(result)
                    }, "json");
            } else if ($.inArray(dialog.mode(), [2, 3]) >= 0) { // 单选，选择单位
                $(dialog.id.left).empty();
                $(dialog.id.left).append($("<option>", {value: treeNode.id}).text(treeNode.name));
            }
        }
    };

    this.tree.onCheck = (this.param.target == 0 || !this.param.multiple) ? null : function (event, treeId, treeNode) {
        var dialog = window.__selectDialog__;

        if (dialog.timeoutId != undefined) {
            window.clearTimeout(dialog.timeoutId);
            dialog.timeoutId = undefined;
        }

        var b = treeNode.checked;

        if (treeNode.children) {
            $.each(treeNode.children, function (i, node) {
                dialog.zTreeObj.checkNode(node, b, false, false);
            });
        }

        var nodes = dialog.zTreeObj.getCheckedNodes(true);
        dialog.availData = nodes;
        $(dialog.id.userGroup).val("");
        $(dialog.id.orgGroup).val("");

        dialog.addToList(nodes); // 对 checked 项目不使用 name 过滤
    }

    this.tree.onExpand = function (event, treeId, treeNode) {
        var dialog = window.__selectDialog__;
        if (dialog.tree.expandIds.length == 0) return;

        dialog.expandNodes(treeNode);
    };

    this.tree.setting = {
        async: {
            enable: true,
            url: this.organizationUrl,
            autoParam: ["id=orgid", "level", "psco"],
            otherParam: null, // init later
            dataFilter: function (treeId, parentNode, responseData) {
                if (responseData) {
                    var dialog = window.__selectDialog__;
                    $.each(responseData, function (i, jsnode) {
                        jsnode.orgType = jsnode.isParent;
                        if (dialog.param.target == 1 && dialog.param.multiple) jsnode.nocheck = jsnode.isParent;
                        if (jsnode.isParent && !jsnode.hasChild) {
                            jsnode.isParent = 0;
                            jsnode.iconSkin = dialog.folderIconSkin;
                        }
                    });
                }
                return responseData;
            }
        },
        callback: {
            onClick: this.tree.onClick,
            onExpand: this.tree.onExpand,
            onCheck: this.tree.onCheck
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        view: {
            selectedMulti: false
        },
        check: (this.param.target == 0 || !this.param.multiple) ? undefined : {
            autoCheckTrigger: false,
            chkboxType: {"Y": "", "N": ""},
            chkStyle: "checkbox",
            enable: true,
            nocheckInherit: false,
            chkDisabledInherit: false
        }
    };
}

selectDialog.prototype.OK = 1;
selectDialog.prototype.CANCEL = 0;
selectDialog.prototype.CLEAR = 2;

selectDialog.prototype.mode = function () {
    return this.param.target + ((this.param.multiple) ? 8 : 0);
};

selectDialog.prototype.expandNodes = function (treeNode) {
    var id = this.tree.expandIds.pop();
    var result = false;
    if (id != undefined) {
        var node = this.zTreeObj.getNodeByParam("id", id, treeNode);
        if (node) {
            if (node.id == this.tree.highlightId[0]) { // company or unit
                $("#" + node.tId + "_span").css({color: "red", background: "yellow"});
            } else if (node.id == this.tree.highlightId[1]) { // department
                $("#" + node.tId + "_span").css({color: "#E800E8", background: "yellow"});
                if (this.param.target == 0 || this.param.target == 4) {
                    this.clickCountDown = 2;
                    $("#" + node.tId + "_a").trigger("click");
                }
            }

            this.zTreeObj.expandNode(node, true, false, false, true);

            result = true;
        } else {
            node = treeNode;
            this.tree.expandIds = [];
            result = false;
        }

        if (node && this.tree.expandIds.length == 0) {
            var container = $(this.id.tree).parent();

            var top = container.position().top;
            var innerHeight = container.innerHeight();

            var nodeTop = $("#" + node.tId).position().top;

            if (top + innerHeight * 9 / 10 < nodeTop) {
                container.scrollTop(nodeTop - top - innerHeight / 10)
            }
        }
    } else {
        result = false;
    }

    return result;
};

selectDialog.prototype.value = function (flag) {
    var result;

    try {
        if (flag != this.CANCEL || !this.data) {
            result = {flag: flag, id: [], name: []};
        } else {
            result = this.data; // restore old data
            result.flag = flag;
        }

        if (flag == this.OK) {
            if (this.mode() < 8) { // zTree + left
                $.each($(this.id.left + " option:selected"), function (i, field) {
                    result.id[0] = field.value;
                    result.name[0] = field.text;
                    return false;
                });
                if (result.id.length == 0) {
                    var o = $(this.id.left + " option");
                    if (o.length >= 1) {
                        result.id[0] = o[0].value;
                        result.name[0] = o[0].text;
                    }
                }
            } else { // zTree + left + right
                $.each($(this.id.right + " option"), function (i, field) {
                    result.id[i] = field.value;
                    result.name[i] = field.text;
                });
            }
        }
    } catch (err) {
        result = {flag: flag, id: [], name: []};
    }

    return result;
};

selectDialog.prototype.valueLength = function () {
    if (this.mode() < 8) { // zTree + left, single choice
        return 0; // omit this value
    } else { // zTree + left + right, multiple choices
        return $(this.id.right + " option").length;
    }
};

joinDwList = function (value) {
    if (!value) return "";
    var result = ""
    $.each(value, function (i, field) {
        if (i == 0) result = field.name;
        else result = result + ", " + field.name;
    })
    return result;
}

selectDialog.prototype.addToList = function (result, nameFilter, b) {
    var dialog = this;
    $(dialog.id.left).empty();

    var k = 0;
    var rightList = $(dialog.id.right);
    result && $.each(result, function (i, field) {
        if (b || dialog.param.includeSelf || (field.id != dialog.selfUserId))
            if ((!nameFilter || field.name.indexOf(nameFilter) >= 0) && rightList.find("option[value='" + field.id + "']").length == 0) {
                k++;
                if (k >= 800) return false;
                if (field.dwList) {
                    var s = joinDwList(field.dwList);
                    if (s) s = field.name + " <" + s + ">"; else s = field.name;
                    $(dialog.id.left).append($("<option>", {value: field.id, title: s}).text(s));
                } else {
                    $(dialog.id.left).append($("<option>", {value: field.id}).text(field.name));
                }
            }
    });
};

// 过滤条件
//
// name: 姓名过滤， like %name%
//
selectDialog.prototype.init = function () {
    // deptFlag:
    // 0：包括部门，
    // 1：不包括部门，
    // 2：当前单位下包括部门，其它单位不包括部门
    var deptFlag = (this.param.target == 2) ? 1 : ((this.param.rootId == "-2") ? 2 : 0);

    if (this.param.target == 0 || this.param.target == 4)
        this.userNameFilter = $.trim($(this.id.userName).val());

    // zTree的过滤条件
    this.tree.setting.async.otherParam = {deptFlag: deptFlag};

    // self user Id
    this.selfUserId = $(this.id.selfUserId).val();

    // 获取组织，初始化zTree，展开第0个节点, 并恢复数据
    $.post(this.organizationUrl, $.param({rootId: this.param.rootId, deptFlag: deptFlag}),
        function (result) {
            var dialog = window.__selectDialog__;

            if ($.isPlainObject(result)) {
                dialog.tree.expandIds = result.expandIds.reverse();
                dialog.tree.highlightId = result.highlightId;
                dialog.tree.expandIds.pop(); // omit the first id: 0
                result = result.zTreeData;
            }

            if (result)
                $.each(result, function (i, jsnode) {
                    jsnode.orgType = jsnode.isParent;
                    if (dialog.param.target == 1 && dialog.param.multiple) jsnode.nocheck = jsnode.isParent;
                    if (jsnode.isParent && !jsnode.hasChild) {
                        jsnode.isParent = 0;
                        jsnode.iconSkin = dialog.folderIconSkin;
                    }
                });

            dialog.zTreeObj = $.fn.zTree.init($(dialog.id.tree), dialog.tree.setting, result);
            if (!dialog.expandNodes(null)) {
                var nodes = dialog.zTreeObj.getNodes();
                if (nodes.length > 0 && nodes[0].isParent && !nodes[0].open) {
                    dialog.zTreeObj.expandNode(nodes[0], true, false, false);
                }
            }

            // 恢复选择框数据
            if (dialog.data && dialog.data.id && dialog.data.id.length > 0) {
                var i, l;
                var jObj = $((dialog.param.multiple) ? dialog.id.right : dialog.id.left);
                for (i = 0, l = dialog.data.id.length; i < l; i++) {
                    jObj.append($("<option>", {value: dialog.data.id[i]}).text(dialog.data.name[i]));
                }
                $(dialog.id.selectedCount).text(dialog.valueLength());
            }

        }, "json");
};

selectDialog.prototype.bindEvent = function () {

    $(this.id.userName).bind("keydown", function (event) {
        if (event.keyCode == 13) $(event.target).trigger("blur");
    })

    $(this.id.userName).bind("input propertychange", function () {
        var dialog = window.__selectDialog__;

        if (!dialog.userNameChanged) {
            dialog.userNameChanged = true;
            $(dialog.id.left).empty();
        }
    });

    $(this.id.userName).bind("blur", function () {
        var dialog = window.__selectDialog__;

        if (dialog.userNameChanged) {
            dialog.userNameChanged = undefined;

            $(dialog.id.orgGroup).val("");

            dialog.userNameFilter = $.trim($(dialog.id.userName).val());

            if (!$(dialog.id.userGroup).val()) // 未选择组
                dialog.availData = null;

            dialog.timeoutId = window.setTimeout(function () {
                var dialog = window.__selectDialog__;
                if (dialog.timeoutId != undefined) {
                    dialog.timeoutId = undefined;

                    if ($(dialog.id.userGroup).val()) { // 本地过滤组成员,
                        dialog.addToList(dialog.availData, dialog.userNameFilter);
                    } else { // 重新从服务端获取数据(数据是已经过滤过的)
                        var node = null;
                        if (dialog.clickCountDown > 0) {
                            node = dialog.zTreeObj.getNodeByParam("id", "1"); // 获取 root Node
                        } else {
                            var nodes = dialog.zTreeObj.getSelectedNodes();
                            if (nodes.length > 0) node = nodes[0];
                        }

                        if (node) {
                            $("#" + node.tId + "_a").trigger("click");
                        }
                    }
                }

            }, 200);
        }
    });

    $(this.id.userName).dblclick(function (event) {
        var dialog = window.__selectDialog__;
        var n = $(event.target);
        var oldvalue = $.trim(n.val());
        n.val("");

        if (oldvalue != "") {
            if (!dialog.userNameChanged) {
                dialog.userNameChanged = true;
                $(dialog.id.orgGroup).val("");
                $(dialog.id.left).empty();
            }
        }
    });

    $(this.id.userGroup).change(function (event) {
        var dialog = window.__selectDialog__;
        var groupid = $(event.target).val();

        $(dialog.id.orgGroup).val("");

        if (!groupid) {
            $(dialog.id.left).empty();

            // todo change left list
            dialog.userNameChanged = true;
            $(dialog.id.userName).trigger("blur");

            return;
        }

        $.post(dialog.userGroupMemberUrl, $.param({groupid: groupid}),
            function (result) {
                var dialog = window.__selectDialog__;
                dialog.availData = result;

                dialog.addToList(dialog.availData, dialog.userNameFilter);
            }, "json");
    });

    $(this.id.orgName).bind("keydown", function (event) {
        if (event.keyCode == 13) $(event.target).trigger("blur");
    })

    $(this.id.orgName).bind("input propertychange", function () {
        var dialog = window.__selectDialog__;

        if (!dialog.orgNameChanged) {
            dialog.orgNameChanged = true;
            $(dialog.id.left).empty();
        }
    });

    $(this.id.orgName).bind("blur", function () {
        var dialog = window.__selectDialog__;

        if (dialog.orgNameChanged) {
            dialog.orgNameChanged = undefined;

            $(dialog.id.userGroup).val("");

            dialog.orgNameFilter = $.trim($(dialog.id.orgName).val());

            if (!$(dialog.id.orgGroup).val()) // 未选择组
                dialog.availData = null;

            dialog.timeoutId = window.setTimeout(function () {
                var dialog = window.__selectDialog__;
                if (dialog.timeoutId != undefined) {
                    dialog.timeoutId = undefined;

                    if ($(dialog.id.orgGroup).val()) { // 本地过滤组成员,
                        dialog.addToList(dialog.availData, dialog.orgNameFilter);
                    } else { // 重新从服务端获取数据(数据是已经过滤过的)
                        if (dialog.orgNameFilter) {
                            $.post(dialog.findOrgUrl, $.param({
                                    rootId: dialog.param.rootId,
                                    name: dialog.orgNameFilter
                                }),
                                function (result) {
                                    var dialog = window.__selectDialog__;
                                    dialog.availData = result;
                                    $(dialog.id.userGroup).val(""); // orgGroup 已经是空的， 这里设置userGroup

                                    dialog.addToList(result)
                                }, "json");
                        }
                    }
                }

            }, 200);
        }
    });

    $(this.id.orgName).dblclick(function (event) {
        var dialog = window.__selectDialog__;
        var n = $(event.target);
        var oldvalue = $.trim(n.val());
        n.val("");

        if (oldvalue != "") {
            if (!dialog.orgNameChanged) {
                dialog.orgNameChanged = true;
                $(dialog.id.userGroup).val("");
                $(dialog.id.left).empty();
            }
        }
    });

    $(this.id.orgGroup).change(function (event) {
        var dialog = window.__selectDialog__;
        var groupid = $(event.target).val();

        $(dialog.id.userGroup).val("");

        if (!groupid) {
            $(dialog.id.left).empty();

            // todo change left list
            dialog.orgNameChanged = true;
            $(dialog.id.orgName).trigger("blur");

            return;
        }

        $.post(dialog.orgGroupMemberUrl, $.param({groupid: groupid}),
            function (result) {
                var dialog = window.__selectDialog__;
                dialog.availData = result;

                dialog.addToList(dialog.availData, dialog.orgNameFilter, true);
            }, "json");
    });


    if (this.param.multiple)
        $(this.id.add).click(function () {
            var dialog = window.__selectDialog__;
            $(dialog.id.left + " option:selected").appendTo(dialog.id.right);
            $.each($(dialog.id.right + " option:selected"), function (i, option) {
                option.title = "";
                var j = option.text.indexOf("<");
                if (j >= 0) option.text = $.trim(option.text.substr(0, j));
            });
            $(dialog.id.selectedCount).text(dialog.valueLength());
        });

    if (this.param.multiple)
        $(this.id.del).click(function () {
            var dialog = window.__selectDialog__;
            if (dialog.availData) {
                var nameFilter = dialog.userNameFilter;
                $.each($(dialog.id.right + " option:selected"), function (i, option) {
                    if (!nameFilter || option.text.indexOf(nameFilter) >= 0)
                        $.each(dialog.availData, function (j, field) {
                            if (field.id == option.value) {
                                if (field.dwList) {
                                    var s = joinDwList(field.dwList);
                                    if (s) s = field.name + " <" + s + ">"; else s = field.name;
                                    $(dialog.id.left).append($("<option>", {value: field.id,  title: s, selected: option.selected}).text(s));
                                } else {
                                    $(dialog.id.left).append($("<option>", {value: field.id, selected: option.selected}).text(field.name));
                                }
                                return false;
                            }
                        });
                });
            }
            $(dialog.id.right + " option:selected").remove();
            $(dialog.id.selectedCount).text(dialog.valueLength());
        });

    if (this.param.multiple)
        $(this.id.addAll).click(function () {
            var dialog = window.__selectDialog__;
            $(dialog.id.left + " option").appendTo(dialog.id.right);
            $.each($(dialog.id.right + " option"), function (i, option) {
                option.title = "";
                var j = option.text.indexOf("<");
                if (j >= 0) option.text = $.trim(option.text.substr(0, j));
            });
            $(dialog.id.selectedCount).text(dialog.valueLength());
        });

    if (this.param.multiple)
        $(this.id.delAll).click(function () {
            var dialog = window.__selectDialog__;
            if (dialog.availData) {
                var nameFilter = dialog.userNameFilter;
                $.each($(dialog.id.right + " option"), function (i, option) {
                    if (!nameFilter || option.text.indexOf(nameFilter) >= 0)
                        $.each(dialog.availData, function (j, field) {
                            if (field.id == option.value) {
                                if (field.dwList) {
                                    var s = joinDwList(field.dwList);
                                    if (s) s = field.name + " <" + s + ">"; else s = field.name;
                                    $(dialog.id.left).append($("<option>", {value: field.id,  title: s, selected: option.selected}).text(s));
                                } else {
                                    $(dialog.id.left).append($("<option>", {value: field.id, selected: option.selected}).text(field.name));
                                }
                                return false;
                            }
                        });
                });
            }
            $(dialog.id.right).empty();
            $(dialog.id.selectedCount).text(dialog.valueLength());
        });

    if (this.param.multiple)
        $(this.id.left).dblclick(function () {
            var dialog = window.__selectDialog__;
            $(dialog.id.add).click();
        });

    if (this.param.multiple) {
        $(this.id.right).dblclick(function () {
            var dialog = window.__selectDialog__;
            $(dialog.id.del).click()
        });
    }

};

selectDialog.prototype.bind = function () {
    this.init();
    this.bindEvent();

    $(".search").click(function (event) {
        var dialog = window.__selectDialog__;
        var n = $(event.target);
        if (n.attr("tag") == "user") {
            dialog.userNameChanged = true;
            $(dialog.id.userName).trigger("blur");
        } else {
            dialog.orgNameChanged = true;
            $(dialog.id.orgName).trigger("blur");
        }
    });
};
