(function() {
  var cordova = window.PhoneGap || window.Cordova || window.cordova;
  var serviceName = 'PhoneDialer';

  var StayAwake = function() {
  }

  // now, stay awake
  StayAwake.prototype.enable = function() {
    cordova.exec(Ext.emptyFn, Ext.emptyFn, 'StayAwake', 'enable', []);
  };

  // now can go to sleep
  StayAwake.prototype.disable = function() {
    cordova.exec(Ext.emptyFn, Ext.emptyFn, 'StayAwake', 'disable', []);
  };

  // initialize
  module.exports = new StayAwake();
})();


