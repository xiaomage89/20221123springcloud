var page=require("webpage").create(),system=require("system");var m=Math.floor(Math.random()*1000000);var address=system.args[1].split("'")[1];var imgDir=system.args[3];var widgetids_arr=system.args[4].split(",");page.viewportSize={width:1200,height:580};page.onAlert=function(a){console.log(a);phantom.exit();};page.onCallback=function(a){console.log(a);phantom.exit();};page.open(address,function(a){if(a!=="success"){console.log("Unable to load the address!");phantom.exit(1);}else{window.setTimeout(function(){var b=page.evaluate(function(){try{return g_dsnEditor.cmd_widgetsPosition(true);}catch(f){alert(f);}});console.log(b);if(widgetids_arr.length>0){for(var c=0;c<widgetids_arr.length;c++){var d=widgetids_arr[c];if(!d){continue;}screenshot(d);page.evaluate(function(h){try{var f=window.document.getElementById(h);if(!!f){f.style.position=window.g_dsnEditor.tempPosition;f.style.zIndex=window.g_dsnEditor.tempZIndex;f.style.backgroundColor=window.g_dsnEditor.tempColor;}}catch(g){alert(g);}},d);}}phantom.exit();},10000);}});function screenshot(b){var a=page.evaluate(window["getBounds"],b);if(!a||a.length<4){return;}page.clipRect={top:parseInt(a[0]),left:parseInt(a[1]),width:parseInt(a[2]),height:parseInt(a[3])};page.render(imgDir+b+"_"+m+++".png");}function getBounds(i){try{var b=new Array();var d=window.document.getElementById(i);if(!!d){var h=1;var g=1;var c=d.scrollWidth;var a=d.scrollHeight;b[0]=h;b[1]=g;b[2]=c;b[3]=a;window.g_dsnEditor.tempPosition=d.style.position;window.g_dsnEditor.tempZIndex=d.style.zIndex;window.g_dsnEditor.tempColor=d.style.backgroundColor;d.style.position="fixed";d.style.backgroundColor="#ffffff";d.style.zIndex=999;d.style.top=h+"px";d.style.left=g+"px";d.style.width=c+"px";d.style.height=a+"px";}return b;}catch(f){alert(f);}}