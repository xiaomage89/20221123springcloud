function beforeGetbounds(){try{var b;if(window.g_rptpage){b=window.g_rptpage.getBodyArea();}else{return;}var a=b.scrollWidth+1;var f=b.scrollHeight+1;var c=window.document.getElementById("tr_rptPageIndex");var g=false;if(!!c&&c.style.display!="none"){g=true;}window.callPhantom("resizeWindow",a+"",f+"",g);}catch(d){alert(d);}}function resizeWindow(){var c=arguments[0];var b=arguments[1];var a=arguments[2];if(a==true){b=parseInt(b)+40;}page.viewportSize={width:parseInt(c),height:parseInt(b)};page.clipRect={top:9,left:0,width:(parseInt(c)+5)>10000?10000:(parseInt(c)+5),height:parseInt(b)>10000?10000:parseInt(b)};}function getBounds_RPT(){try{var b=arguments[0].toString();var d=window.document.getElementById(b);if(!d){alert("currentId错误："+b);}var h=d.getBoundingClientRect().top;var g=d.getBoundingClientRect().left;var c=d.offsetWidth;var a=d.offsetHeight;bounds=[h,g,c,a];window.callPhantom("getBounds_CallBack",bounds.toString());}catch(f){console.log("getBounds_RPT异常："+f);alert(f);}}function getBounds_CallBack(){try{var a=arguments[0];var d=system.args[8];d=parseInt(d)<1?99:parseInt(d);var j;if(a!=null){boundsArr=a.toString().split(",");if(boundsArr.length>=4){var f=boundsArr[0];var b=boundsArr[1];var c=boundsArr[2];var k=boundsArr[3];var i=(k/(c/595))/842;d=d>i?i:d;j=[f,b,c,k,page_Index,d];}}if(page_Index<d){evaluate("turntoCurrentPage",system.args[9]);evaluate("setPageBounds",j.toString());var h=setTimeout(function(){doScreenshot();page_Index++;evaluate("getBounds_RPT",currentId);clearTimeout(h);},2000);}else{phantom.exit();}}catch(g){console.log("getBounds_CallBack异常："+g);}}function setPageBounds(){try{var k=arguments[0];if(k!=null){k=k.toString().split(",");if(k.length>=4){var g=k[0];var c=k[1];var f=k[2];var l=k[3];var j=k[4];var h=k[5];var b=842*f/595;var d=Number(g)+Number(j)*b;if(Number(j)+1>h){b=Number(l)-d+40;}var a=[d,c,f,b];window.callPhantom("setBounds",a);}}}catch(i){console.log("setPageBounds异常："+i);}}function turntoCurrentPage(){try{var a=arguments[0].toString();if(window.g_rptpage&&!!a){var h=window.g_rptpage.getGrids();var d=a.replaceAll(";",",").toArray();for(var g=0;g<d.length;g++){var f=d[g].substring(0,d[g].indexOf("="));var c=d[g].substring(d[g].indexOf("=")+1);var b=window.g_rptpage[f.toLowerCase()+"pagebar"];if(!!b){b._gotoPage(parseInt(c));}}}}catch(j){console.log("setPageBounds异常："+j);}}