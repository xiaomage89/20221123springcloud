function getBounds_EPPT(){try{var h=arguments[0].toString().split("_");var f=h[0];var g=h[1];var a;window.document.getElementsByClassName("ppt-paly-pagebtn left")[0].className+=" eui-hide";window.document.getElementsByClassName("ppt-paly-pagebtn right")[0].className+=" eui-hide";var j=window.p_dsn;if(!j.curPage.id.equalsIgnoreCase(f)){$(j.curPage.getBaseDom()).remove();j.jumpPage(f);}var b=window.document.getElementById(g);if(b==null){a=[1,1,1,1];}else{if(typeof(b)){var k=b.getBoundingClientRect().top;var d=b.getBoundingClientRect().left;var c=b.offsetWidth;var l=b.offsetHeight;a=[k,d,c,l];}}window.callPhantom("getBounds_CallBack",a.toString());}catch(i){alert("出错啦QAQ"+i);}}function getBounds_CallBack(){var a=arguments[0].toString();if(a!=null){a=a.split(",");if(a.length>=4){setBounds(a);}}setTimeout(function(){doScreenshot();evaluate("toNextPage_EPPT");},parseInt(system.args[9])*1000);}function toNextPage_EPPT(){window.callPhantom("toNext_EPPT_CallBack");}function toNext_EPPT_CallBack(){currentId=screenshotObjs[objIndex++];if(currentId==null){phantom.exit();}else{page.evaluate(getBounds_EPPT,currentId,zoom,format);}}