
//toast为插件id，要跟cordova_plugins.js中的id一致
cordova.define("toast",   function(require, exports, module){
    var exec = require("cordova/exec");
    module.exports = {
        show: function(content, type){
            //参数1：成功回调function
            //参数2：失败回调function
            //参数3：feature name，与config.xml中注册的一致
            //参数4：要传递的参数，json格式
            exec(null,null,"toast","show",[content,type]);
        },
        submit: function(content){
              exec(null,null,"toast","submit",[content]);
        }

    }
});