<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="headerTemplate.jsp"></jsp:include>
</head>

<body>

	<div id="wrapper">
      <jsp:include page="sideTemplate.jsp"></jsp:include>
		<div id="page-wrapper" >
		

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">EBAS online services</h1>
					</div>
				</div>
				<!-- /.row -->

				<div id="posWel">
					<p>
						<a href="#"><b>Enterprise Business Application Software
								(EBAS)</b></a> is a cost effective, open standard, web-based ICT
						(Information & Communication Technology) solution for <b>complete
							port business</b>, covering core operations and standard management
						functions. Core functions of the port constitute Vessel & Barge
						operations, Cargo (Dry bulk, Break bulk, Liquid bulk) and
						Container operations, Railway operations, Plant & Equipment
						(Mechanical & Electrical Engineering aspects), Infrastructure &
						Civic Facilities (Civil Engineering aspects) etc. Standard
						management functions of the port constitute Finance (Accounting,
						Budget, Billing, Payment and Revenue), Administration (Estate
						Management, Legal Cases, Management Information System for
						Regulatory Authority), Personnel & Industrial Relation (Human
						Resource, Training, Recruitment), Health Care, Materials
						Management etc. The developed solution boasts features like user
						friendly interfaces, easy deployment of modules, trade
						documentation etc specifically catering to the demand of Indian
						Major Ports. It provides near real time seamless integration with
						external system like, <a target="_blank"
							href="https://www.indianpcs.gov.in">IPA-PCS</a>, <a
							target="_blank" href="https://icegate.gov.in/">Customs</a>,
						Railway and Financial Institutions etc. that classify as G2G
						(Govt. to Govt.) and G2B (Govt. to Business) services. It is also
						capable of near real time business information sharing interfaces
						with stakeholder through email and website.
					</p>
					<script type="text/javascript">
					
(function(f,g,c,h,e,k,i){/*! Jssor */
new(function(){});var d={Fd:function(a){return-c.cos(a*c.PI)/2+.5},Jb:function(a){return a},ee:function(a){return-a*(a-2)},Kd:function(a){return a*a*a}};var b=new function(){var j=this,xb=/\S+/g,F=1,wb=2,cb=3,bb=4,fb=5,G,r=0,l=0,s=0,Y=0,A=0,I=navigator,kb=I.appName,o=I.userAgent,p=parseFloat;function Fb(){if(!G){G={Xe:"ontouchstart"in f||"createTouch"in g};var a;if(I.pointerEnabled||(a=I.msPointerEnabled))G.qd=a?"msTouchAction":"touchAction"}return G}function v(i){if(!r){r=-1;if(kb=="Microsoft Internet Explorer"&&!!f.attachEvent&&!!f.ActiveXObject){var e=o.indexOf("MSIE");r=F;s=p(o.substring(e+5,o.indexOf(";",e)));/*@cc_on Y=@_jscript_version@*/;l=g.documentMode||s}else if(kb=="Netscape"&&!!f.addEventListener){var d=o.indexOf("Firefox"),b=o.indexOf("Safari"),h=o.indexOf("Chrome"),c=o.indexOf("AppleWebKit");if(d>=0){r=wb;l=p(o.substring(d+8))}else if(b>=0){var j=o.substring(0,b).lastIndexOf("/");r=h>=0?bb:cb;l=p(o.substring(j+1,b))}else{var a=/Trident\/.*rv:([0-9]{1,}[\.0-9]{0,})/i.exec(o);if(a){r=F;l=s=p(a[1])}}if(c>=0)A=p(o.substring(c+12))}else{var a=/(opera)(?:.*version|)[ \/]([\w.]+)/i.exec(o);if(a){r=fb;l=p(a[2])}}}return i==r}function q(){return v(F)}function vb(){return q()&&(l<6||g.compatMode=="BackCompat")}function ab(){return v(cb)}function eb(){return v(fb)}function rb(){return ab()&&A>534&&A<535}function J(){v();return A>537||l>42||r==F&&l>=11}function tb(){return q()&&l<9}function sb(a){var b,c;return function(f){if(!b){b=e;var d=a.substr(0,1).toUpperCase()+a.substr(1);n([a].concat(["WebKit","ms","Moz","O","webkit"]),function(g,e){var b=a;if(e)b=g+d;if(f.style[b]!=i)return c=b})}return c}}function qb(b){var a;return function(c){a=a||sb(b)(c)||b;return a}}var K=qb("transform");function jb(a){return{}.toString.call(a)}var gb={};n(["Boolean","Number","String","Function","Array","Date","RegExp","Object"],function(a){gb["[object "+a+"]"]=a.toLowerCase()});function n(b,d){var a,c;if(jb(b)=="[object Array]"){for(a=0;a<b.length;a++)if(c=d(b[a],a,b))return c}else for(a in b)if(c=d(b[a],a,b))return c}function D(a){return a==h?String(a):gb[jb(a)]||"object"}function hb(a){for(var b in a)return e}function B(a){try{return D(a)=="object"&&!a.nodeType&&a!=a.window&&(!a.constructor||{}.hasOwnProperty.call(a.constructor.prototype,"isPrototypeOf"))}catch(b){}}function u(a,b){return{x:a,y:b}}function nb(b,a){setTimeout(b,a||0)}function H(b,d,c){var a=!b||b=="inherit"?"":b;n(d,function(c){var b=c.exec(a);if(b){var d=a.substr(0,b.index),e=a.substr(b.index+b[0].length+1,a.length-1);a=d+e}});a=c+(!a.indexOf(" ")?"":" ")+a;return a}function pb(b,a){if(l<9)b.style.filter=a}j.Ye=Fb;j.sd=q;j.lf=ab;j.wd=eb;j.ef=J;j.bc=tb;sb("transform");j.Dd=function(){return l};j.hf=function(){v();return A};j.Rb=nb;function V(a){a.constructor===V.caller&&a.Id&&a.Id.apply(a,V.caller.arguments)}j.Id=V;j.mb=function(a){if(j.Re(a))a=g.getElementById(a);return a};function t(a){return a||f.event}j.Md=t;j.ic=function(b){b=t(b);var a=b.target||b.srcElement||g;if(a.nodeType==3)a=j.Ld(a);return a};j.id=function(a){a=t(a);return{x:a.pageX||a.clientX||0,y:a.pageY||a.clientY||0}};function w(c,d,a){if(a!==i)c.style[d]=a==i?"":a;else{var b=c.currentStyle||c.style;a=b[d];if(a==""&&f.getComputedStyle){b=c.ownerDocument.defaultView.getComputedStyle(c,h);b&&(a=b.getPropertyValue(d)||b[d])}return a}}function X(b,c,a,d){if(a!==i){if(a==h)a="";else d&&(a+="px");w(b,c,a)}else return p(w(b,c))}function m(c,a){var d=a?X:w,b;if(a&4)b=qb(c);return function(e,f){return d(e,b?b(e):c,f,a&2)}}function Ab(b){if(q()&&s<9){var a=/opacity=([^)]*)/.exec(b.style.filter||"");return a?p(a[1])/100:1}else return p(b.style.opacity||"1")}function Cb(b,a,f){if(q()&&s<9){var h=b.style.filter||"",i=new RegExp(/[\s]*alpha\([^\)]*\)/g),e=c.round(100*a),d="";if(e<100||f)d="alpha(opacity="+e+") ";var g=H(h,[i],d);pb(b,g)}else b.style.opacity=a==1?"":c.round(a*100)/100}var L={T:["rotate"],bb:["rotateX"],Y:["rotateY"],Mb:["skewX"],Lb:["skewY"]};if(!J())L=C(L,{H:["scaleX",2],J:["scaleY",2],S:["translateZ",1]});function M(d,a){var c="";if(a){if(q()&&l&&l<10){delete a.bb;delete a.Y;delete a.S}b.f(a,function(d,b){var a=L[b];if(a){var e=a[1]||0;if(N[b]!=d)c+=" "+a[0]+"("+d+(["deg","px",""])[e]+")"}});if(J()){if(a.kb||a.lb||a.S!=i)c+=" translate3d("+(a.kb||0)+"px,"+(a.lb||0)+"px,"+(a.S||0)+"px)";if(a.H==i)a.H=1;if(a.J==i)a.J=1;if(a.H!=1||a.J!=1)c+=" scale3d("+a.H+", "+a.J+", 1)"}}d.style[K(d)]=c}j.Nc=m("transformOrigin",4);j.Ce=m("backfaceVisibility",4);j.De=m("transformStyle",4);j.nf=m("perspective",6);j.Ee=m("perspectiveOrigin",4);j.Fe=function(a,b){if(q()&&s<9||s<10&&vb())a.style.zoom=b==1?"":b;else{var c=K(a),f="scale("+b+")",e=a.style[c],g=new RegExp(/[\s]*scale\(.*?\)/g),d=H(e,[g],f);a.style[c]=d}};j.Pb=function(b,a){return function(c){c=t(c);var e=c.type,d=c.relatedTarget||(e=="mouseout"?c.toElement:c.fromElement);(!d||d!==a&&!j.Ge(a,d))&&b(c)}};j.c=function(a,d,b,c){a=j.mb(a);if(a.addEventListener){d=="mousewheel"&&a.addEventListener("DOMMouseScroll",b,c);a.addEventListener(d,b,c)}else if(a.attachEvent){a.attachEvent("on"+d,b);c&&a.setCapture&&a.setCapture()}};j.R=function(a,c,d,b){a=j.mb(a);if(a.removeEventListener){c=="mousewheel"&&a.removeEventListener("DOMMouseScroll",d,b);a.removeEventListener(c,d,b)}else if(a.detachEvent){a.detachEvent("on"+c,d);b&&a.releaseCapture&&a.releaseCapture()}};j.Kb=function(a){a=t(a);a.preventDefault&&a.preventDefault();a.cancel=e;a.returnValue=k};j.Je=function(a){a=t(a);a.stopPropagation&&a.stopPropagation();a.cancelBubble=e};j.I=function(d,c){var a=[].slice.call(arguments,2),b=function(){var b=a.concat([].slice.call(arguments,0));return c.apply(d,b)};return b};j.Le=function(a,b){if(b==i)return a.textContent||a.innerText;var c=g.createTextNode(b);j.nc(a);a.appendChild(c)};j.dc=function(d,c){for(var b=[],a=d.firstChild;a;a=a.nextSibling)(c||a.nodeType==1)&&b.push(a);return b};function ib(a,c,e,b){b=b||"u";for(a=a?a.firstChild:h;a;a=a.nextSibling)if(a.nodeType==1){if(S(a,b)==c)return a;if(!e){var d=ib(a,c,e,b);if(d)return d}}}j.q=ib;function Q(a,d,f,b){b=b||"u";var c=[];for(a=a?a.firstChild:h;a;a=a.nextSibling)if(a.nodeType==1){S(a,b)==d&&c.push(a);if(!f){var e=Q(a,d,f,b);if(e.length)c=c.concat(e)}}return c}function db(a,c,d){for(a=a?a.firstChild:h;a;a=a.nextSibling)if(a.nodeType==1){if(a.tagName==c)return a;if(!d){var b=db(a,c,d);if(b)return b}}}j.xf=db;function ub(a,c,e){var b=[];for(a=a?a.firstChild:h;a;a=a.nextSibling)if(a.nodeType==1){(!c||a.tagName==c)&&b.push(a);if(!e){var d=ub(a,c,e);if(d.length)b=b.concat(d)}}return b}j.vf=ub;j.uf=function(b,a){return b.getElementsByTagName(a)};function C(){var e=arguments,d,c,b,a,g=1&e[0],f=1+g;d=e[f-1]||{};for(;f<e.length;f++)if(c=e[f])for(b in c){a=c[b];if(a!==i){a=c[b];var h=d[b];d[b]=g&&(B(h)||B(a))?C(g,{},h,a):a}}return d}j.u=C;function W(f,g){var d={},c,a,b;for(c in f){a=f[c];b=g[c];if(a!==b){var e;if(B(a)&&B(b)){a=W(a,b);e=!hb(a)}!e&&(d[c]=a)}}return d}j.Xc=function(a){return D(a)=="function"};j.Re=function(a){return D(a)=="string"};j.Tc=function(a){return!isNaN(p(a))&&isFinite(a)};j.f=n;j.de=B;function P(a){return g.createElement(a)}j.ob=function(){return P("DIV")};j.qf=function(){return P("SPAN")};j.Oc=function(){};function T(b,c,a){if(a==i)return b.getAttribute(c);b.setAttribute(c,a)}function S(a,b){return T(a,b)||T(a,"data-"+b)}j.v=T;j.l=S;function y(b,a){if(a==i)return b.className;b.className=a}j.qc=y;function mb(b){var a={};n(b,function(b){if(b!=i)a[b]=b});return a}function ob(b,a){return b.match(a||xb)}function O(b,a){return mb(ob(b||"",a))}j.wf=ob;function Z(b,c){var a="";n(c,function(c){a&&(a+=b);a+=c});return a}function E(a,c,b){y(a,Z(" ",C(W(O(y(a)),O(c)),O(b))))}j.Ld=function(a){return a.parentNode};j.P=function(a){j.V(a,"none")};j.z=function(a,b){j.V(a,b?"none":"")};j.Ie=function(b,a){b.removeAttribute(a)};j.ue=function(){return q()&&l<10};j.ie=function(d,a){if(a)d.style.clip="rect("+c.round(a.i||a.C||0)+"px "+c.round(a.n)+"px "+c.round(a.p)+"px "+c.round(a.g||a.E||0)+"px)";else if(a!==i){var g=d.style.cssText,f=[new RegExp(/[\s]*clip: rect\(.*?\)[;]?/i),new RegExp(/[\s]*cliptop: .*?[;]?/i),new RegExp(/[\s]*clipright: .*?[;]?/i),new RegExp(/[\s]*clipbottom: .*?[;]?/i),new RegExp(/[\s]*clipleft: .*?[;]?/i)],e=H(g,f,"");b.Ib(d,e)}};j.U=function(){return+new Date};j.B=function(b,a){b.appendChild(a)};j.fc=function(b,a,c){(c||a.parentNode).insertBefore(b,a)};j.zb=function(b,a){a=a||b.parentNode;a&&a.removeChild(b)};j.Rd=function(a,b){n(a,function(a){j.zb(a,b)})};j.nc=function(a){j.Rd(j.dc(a,e),a)};j.Td=function(a,b){var c=j.Ld(a);b&1&&j.D(a,(j.k(c)-j.k(a))/2);b&2&&j.F(a,(j.m(c)-j.m(a))/2)};j.Pd=function(b,a){return parseInt(b,a||10)};j.Od=p;j.Ge=function(b,a){var c=g.body;while(a&&b!==a&&c!==a)try{a=a.parentNode}catch(d){return k}return b===a};function U(d,c,b){var a=d.cloneNode(!c);!b&&j.Ie(a,"id");return a}j.W=U;j.Ab=function(d,f){var a=new Image;function b(e,d){j.R(a,"load",b);j.R(a,"abort",c);j.R(a,"error",c);f&&f(a,d)}function c(a){b(a,e)}if(eb()&&l<11.6||!d)b(!d);else{j.c(a,"load",b);j.c(a,"abort",c);j.c(a,"error",c);a.src=d}};j.Vd=function(d,a,e){var c=d.length+1;function b(b){c--;if(a&&b&&b.src==a.src)a=b;!c&&e&&e(a)}n(d,function(a){j.Ab(a.src,b)});b()};j.Sc=function(a,g,i,h){if(h)a=U(a);var c=Q(a,g);if(!c.length)c=b.uf(a,g);for(var f=c.length-1;f>-1;f--){var d=c[f],e=U(i);y(e,y(d));b.Ib(e,d.style.cssText);b.fc(e,d);b.zb(d)}return a};function Db(a){var l=this,p="",r=["av","pv","ds","dn"],e=[],q,k=0,f=0,d=0;function h(){E(a,q,e[d||k||f&2||f]);b.O(a,"pointer-events",d?"none":"")}function c(){k=0;h();j.R(g,"mouseup",c);j.R(g,"touchend",c);j.R(g,"touchcancel",c)}function o(a){if(d)j.Kb(a);else{k=4;h();j.c(g,"mouseup",c);j.c(g,"touchend",c);j.c(g,"touchcancel",c)}}l.Rc=function(a){if(a===i)return f;f=a&2||a&1;h()};l.Tb=function(a){if(a===i)return!d;d=a?0:3;h()};l.ib=a=j.mb(a);var m=b.wf(y(a));if(m)p=m.shift();n(r,function(a){e.push(p+a)});q=Z(" ",e);e.unshift("");j.c(a,"mousedown",o);j.c(a,"touchstart",o)}j.Zb=function(a){return new Db(a)};j.O=w;j.qb=m("overflow");j.F=m("top",2);j.D=m("left",2);j.k=m("width",2);j.m=m("height",2);j.oc=m("marginLeft",2);j.sc=m("marginTop",2);j.s=m("position");j.V=m("display");j.L=m("zIndex",1);j.Eb=function(b,a,c){if(a!=i)Cb(b,a,c);else return Ab(b)};j.Ib=function(a,b){if(b!=i)a.style.cssText=b;else return a.style.cssText};j.Xd=function(b,a){if(a===i){a=w(b,"backgroundImage")||"";var c=/\burl\s*\(\s*["']?([^"'\r\n,]+)["']?\s*\)/gi.exec(a)||[];return c[1]}w(b,"backgroundImage",a?"url('"+a+"')":"")};var R={A:j.Eb,i:j.F,g:j.D,db:j.k,Z:j.m,Cb:j.s,Lf:j.V,Q:j.L};function x(f,l){var e=tb(),b=J(),d=rb(),g=K(f);function k(b,d,a){var e=b.jb(u(-d/2,-a/2)),f=b.jb(u(d/2,-a/2)),g=b.jb(u(d/2,a/2)),h=b.jb(u(-d/2,a/2));b.jb(u(300,300));return u(c.min(e.x,f.x,g.x,h.x)+d/2,c.min(e.y,f.y,g.y,h.y)+a/2)}function a(d,a){a=a||{};var n=a.S||0,p=(a.bb||0)%360,q=(a.Y||0)%360,u=(a.T||0)%360,l=a.H,m=a.J,f=a.Kf;if(l==i)l=1;if(m==i)m=1;if(f==i)f=1;if(e){n=0;p=0;q=0;f=0}var c=new zb(a.kb,a.lb,n);c.bb(p);c.Y(q);c.qe(u);c.pe(a.Mb,a.Lb);c.Sb(l,m,f);if(b){c.sb(a.E,a.C);d.style[g]=c.ne()}else if(!Y||Y<9){var o="",h={x:0,y:0};if(a.hb)h=k(c,a.hb,a.nb);j.sc(d,h.y);j.oc(d,h.x);o=c.ke();var s=d.style.filter,t=new RegExp(/[\s]*progid:DXImageTransform\.Microsoft\.Matrix\([^\)]*\)/g),r=H(s,[t],o);pb(d,r)}}x=function(e,c){c=c||{};var g=c.E,k=c.C,f;n(R,function(a,b){f=c[b];f!==i&&a(e,f)});j.ie(e,c.a);if(!b){g!=i&&j.D(e,(c.Pc||0)+g);k!=i&&j.F(e,(c.zd||0)+k)}if(c.he)if(d)nb(j.I(h,M,e,c));else a(e,c)};j.rb=M;if(d)j.rb=x;if(e)j.rb=a;else if(!b)a=M;j.M=x;x(f,l)}j.rb=x;j.M=x;function zb(j,k,o){var d=this,b=[1,0,0,0,0,1,0,0,0,0,1,0,j||0,k||0,o||0,1],i=c.sin,g=c.cos,l=c.tan;function f(a){return a*c.PI/180}function n(a,b){return{x:a,y:b}}function m(c,e,l,m,o,r,t,u,w,z,A,C,E,b,f,k,a,g,i,n,p,q,s,v,x,y,B,D,F,d,h,j){return[c*a+e*p+l*x+m*F,c*g+e*q+l*y+m*d,c*i+e*s+l*B+m*h,c*n+e*v+l*D+m*j,o*a+r*p+t*x+u*F,o*g+r*q+t*y+u*d,o*i+r*s+t*B+u*h,o*n+r*v+t*D+u*j,w*a+z*p+A*x+C*F,w*g+z*q+A*y+C*d,w*i+z*s+A*B+C*h,w*n+z*v+A*D+C*j,E*a+b*p+f*x+k*F,E*g+b*q+f*y+k*d,E*i+b*s+f*B+k*h,E*n+b*v+f*D+k*j]}function e(c,a){return m.apply(h,(a||b).concat(c))}d.Sb=function(a,c,d){if(a!=1||c!=1||d!=1)b=e([a,0,0,0,0,c,0,0,0,0,d,0,0,0,0,1])};d.sb=function(a,c,d){b[12]+=a||0;b[13]+=c||0;b[14]+=d||0};d.bb=function(c){if(c){a=f(c);var d=g(a),h=i(a);b=e([1,0,0,0,0,d,h,0,0,-h,d,0,0,0,0,1])}};d.Y=function(c){if(c){a=f(c);var d=g(a),h=i(a);b=e([d,0,-h,0,0,1,0,0,h,0,d,0,0,0,0,1])}};d.qe=function(c){if(c){a=f(c);var d=g(a),h=i(a);b=e([d,h,0,0,-h,d,0,0,0,0,1,0,0,0,0,1])}};d.pe=function(a,c){if(a||c){j=f(a);k=f(c);b=e([1,l(k),0,0,l(j),1,0,0,0,0,1,0,0,0,0,1])}};d.jb=function(c){var a=e(b,[1,0,0,0,0,1,0,0,0,0,1,0,c.x,c.y,0,1]);return n(a[12],a[13])};d.ne=function(){return"matrix3d("+b.join(",")+")"};d.ke=function(){return"progid:DXImageTransform.Microsoft.Matrix(M11="+b[0]+", M12="+b[4]+", M21="+b[1]+", M22="+b[5]+", SizingMethod='auto expand')"}}new function(){var a=this;function b(d,g){for(var j=d[0].length,i=d.length,h=g[0].length,f=[],c=0;c<i;c++)for(var k=f[c]=[],b=0;b<h;b++){for(var e=0,a=0;a<j;a++)e+=d[c][a]*g[a][b];k[b]=e}return f}a.H=function(b,c){return a.Ic(b,c,0)};a.J=function(b,c){return a.Ic(b,0,c)};a.Ic=function(a,c,d){return b(a,[[c,0],[0,d]])};a.jb=function(d,c){var a=b(d,[[c.x],[c.y]]);return u(a[0][0],a[1][0])}};var N={Pc:0,zd:0,E:0,C:0,G:1,H:1,J:1,T:0,bb:0,Y:0,kb:0,lb:0,S:0,Mb:0,Lb:0};j.Hc=function(c,d){var a=c||{};if(c)if(b.Xc(c))a={cb:a};else if(b.Xc(c.a))a.a={cb:c.a};a.cb=a.cb||d;if(a.a)a.a.cb=a.a.cb||d;return a};j.hd=function(l,m,x,q,z,A,n){var a=m;if(l){a={};for(var g in m){var B=A[g]||1,w=z[g]||[0,1],f=(x-w[0])/w[1];f=c.min(c.max(f,0),1);f=f*B;var u=c.floor(f);if(f!=u)f-=u;var j=q.cb||d.Jb,k,C=l[g],o=m[g];if(b.Tc(o)){j=q[g]||j;var y=j(f);k=C+o*y}else{k=b.u({Hb:{}},l[g]);var v=q[g]||{};b.f(o.Hb||o,function(d,a){j=v[a]||v.cb||j;var c=j(f),b=d*c;k.Hb[a]=b;k[a]+=b})}a[g]=k}var t=b.f(m,function(b,a){return N[a]!=i});t&&b.f(N,function(c,b){if(a[b]==i&&l[b]!==i)a[b]=l[b]});if(t){if(a.G)a.H=a.J=a.G;a.hb=n.hb;a.nb=n.nb;a.he=e}}if(m.a&&n.sb){var p=a.a.Hb,s=(p.i||0)+(p.p||0),r=(p.g||0)+(p.n||0);a.g=(a.g||0)+r;a.i=(a.i||0)+s;a.a.g-=r;a.a.n-=r;a.a.i-=s;a.a.p-=s}if(a.a&&b.ue()&&!a.a.i&&!a.a.g&&!a.a.C&&!a.a.E&&a.a.n==n.hb&&a.a.p==n.nb)a.a=h;return a}};function m(){var a=this,d=[];function i(a,b){d.push({jc:a,mc:b})}function h(a,c){b.f(d,function(b,e){b.jc==a&&b.mc===c&&d.splice(e,1)})}a.Gb=a.addEventListener=i;a.removeEventListener=h;a.j=function(a){var c=[].slice.call(arguments,1);b.f(d,function(b){b.jc==a&&b.mc.apply(f,c)})}}var l=function(z,E,g,K,N,M){z=z||0;var a=this,q,o,p,u,B=0,H,I,G,C,y=0,j=0,m=0,F,l,i,d,n,D,w=[],x;function P(a){i+=a;d+=a;l+=a;j+=a;m+=a;y+=a}function t(p){var f=p;if(n)if(!D&&(f>=d||f<i)||D&&f>=n)f=((f-i)%n+n)%n+i;if(!F||u||j!=f){var h=c.min(f,d);h=c.max(h,i);if(!F||u||h!=m){if(M){var k=(h-l)/(E||1);if(g.Ad)k=1-k;var o=b.hd(N,M,k,H,G,I,g);if(x)b.f(o,function(b,a){x[a]&&x[a](K,b)});else b.M(K,o)}a.kc(m-l,h-l);var r=m,q=m=h;b.f(w,function(b,c){var a=f<=j?w[w.length-c-1]:b;a.gb(m-y)});j=f;F=e;a.Nb(r,q)}}}function A(a,b,e){b&&a.Ob(d);if(!e){i=c.min(i,a.yd()+y);d=c.max(d,a.rc()+y)}w.push(a)}var r=f.requestAnimationFrame||f.webkitRequestAnimationFrame||f.mozRequestAnimationFrame||f.msRequestAnimationFrame;if(b.lf()&&b.Dd()<7)r=h;r=r||function(a){b.Rb(a,g.eb)};function J(){if(q){var d=b.U(),e=c.min(d-B,g.ud),a=j+e*p;B=d;if(a*p>=o*p)a=o;t(a);if(!u&&a*p>=o*p)L(C);else r(J)}}function s(f,g,h){if(!q){q=e;u=h;C=g;f=c.max(f,i);f=c.min(f,d);o=f;p=o<j?-1:1;a.td();B=b.U();r(J)}}function L(b){if(q){u=q=C=k;a.rd();b&&b()}}a.pd=function(a,b,c){s(a?j+a:d,b,c)};a.od=s;a.tb=L;a.Zd=function(a){s(a)};a.X=function(){return j};a.md=function(){return o};a.yb=function(){return m};a.gb=t;a.sb=function(a){t(j+a)};a.ld=function(){return q};a.Yd=function(a){n=a};a.Ob=P;a.Qc=function(a,b){A(a,0,b)};a.tc=function(a){A(a,1)};a.yd=function(){return i};a.rc=function(){return d};a.Nb=a.td=a.rd=a.kc=b.Oc;a.gc=b.U();g=b.u({eb:16,ud:50},g);n=g.hc;D=g.ae;x=g.be;i=l=z;d=z+E;I=g.Bd||{};G=g.lc||{};H=b.Hc(g.K)};var o=new function(){var h=this;function g(b,a,c){c.push(a);b[a]=b[a]||[];b[a].push(c)}h.Qd=function(d){for(var e=[],a,b=0;b<d.fb;b++)for(a=0;a<d.o;a++)g(e,c.ceil(1e5*c.random())%13,[b,a]);return e}},s=function(n,s,q,u,z){var f=this,v,g,a,y=0,x=u.rf,r,i=8;function t(a){if(a.i)a.C=a.i;if(a.g)a.E=a.g;b.f(a,function(a){b.de(a)&&t(a)})}function j(g,f){var a={eb:f,Ub:1,Rb:0,o:1,fb:1,A:0,G:0,a:0,sb:k,Vb:k,Ad:k,Af:o.Qd,Hd:{yf:0,of:0},K:d.Fd,Bd:{},Yb:[],lc:{}};b.u(a,g);t(a);a.K=b.Hc(a.K,d.Fd);a.sf=c.ceil(a.Ub/a.eb);a.tf=function(c,b){c/=a.o;b/=a.fb;var f=c+"x"+b;if(!a.Yb[f]){a.Yb[f]={db:c,Z:b};for(var d=0;d<a.o;d++)for(var e=0;e<a.fb;e++)a.Yb[f][e+","+d]={i:e*b,n:d*c+c,p:e*b+b,g:d*c}}return a.Yb[f]};if(a.pc){a.pc=j(a.pc,f);a.Vb=e}return a}function p(B,i,a,w,o,m){var z=this,u,v={},j={},n=[],f,d,s,q=a.Hd.yf||0,r=a.Hd.of||0,g=a.tf(o,m),p=C(a),D=p.length-1,t=a.Ub+a.Rb*D,x=w+t,l=a.Vb,y;x+=50;function C(a){var b=a.Af(a);return a.Ad?b.reverse():b}z.cd=x;z.cc=function(d){d-=w;var e=d<t;if(e||y){y=e;if(!l)d=t-d;var f=c.ceil(d/a.eb);b.f(j,function(a,e){var d=c.max(f,a.zf);d=c.min(d,a.length-1);if(a.dd!=d){if(!a.dd&&!l)b.z(n[e]);else d==a.mf&&l&&b.P(n[e]);a.dd=d;b.M(n[e],a[d])}})}};i=b.W(i);b.rb(i,h);if(b.bc()){var E=!i["no-image"],A=b.vf(i);b.f(A,function(a){(E||a["jssor-slider"])&&b.Eb(a,b.Eb(a),e)})}b.f(p,function(h,i){b.f(h,function(G){var K=G[0],J=G[1],t=K+","+J,n=k,p=k,x=k;if(q&&J%2){if(q&3)n=!n;if(q&12)p=!p;if(q&16)x=!x}if(r&&K%2){if(r&3)n=!n;if(r&12)p=!p;if(r&16)x=!x}a.i=a.i||a.a&4;a.p=a.p||a.a&8;a.g=a.g||a.a&1;a.n=a.n||a.a&2;var E=p?a.p:a.i,B=p?a.i:a.p,D=n?a.n:a.g,C=n?a.g:a.n;a.a=E||B||D||C;s={};d={C:0,E:0,A:1,db:o,Z:m};f=b.u({},d);u=b.u({},g[t]);if(a.A)d.A=2-a.A;if(a.Q){d.Q=a.Q;f.Q=0}var I=a.o*a.fb>1||a.a;if(a.G||a.T){var H=e;if(b.bc())if(a.o*a.fb>1)H=k;else I=k;if(H){d.G=a.G?a.G-1:1;f.G=1;if(b.bc()||b.wd())d.G=c.min(d.G,2);var N=a.T||0;d.T=N*360*(x?-1:1);f.T=0}}if(I){var h=u.Hb={};if(a.a){var w=a.Ef||1;if(E&&B){h.i=g.Z/2*w;h.p=-h.i}else if(E)h.p=-g.Z*w;else if(B)h.i=g.Z*w;if(D&&C){h.g=g.db/2*w;h.n=-h.g}else if(D)h.n=-g.db*w;else if(C)h.g=g.db*w}s.a=u;f.a=g[t]}var L=n?1:-1,M=p?1:-1;if(a.x)d.E+=o*a.x*L;if(a.y)d.C+=m*a.y*M;b.f(d,function(a,c){if(b.Tc(a))if(a!=f[c])s[c]=a-f[c]});v[t]=l?f:d;var F=a.sf,A=c.round(i*a.Rb/a.eb);j[t]=new Array(A);j[t].zf=A;j[t].mf=A+F-1;for(var z=0;z<=F;z++){var y=b.hd(f,s,z/F,a.K,a.lc,a.Bd,{sb:a.sb,hb:o,nb:m});y.Q=y.Q||1;j[t].push(y)}})});p.reverse();b.f(p,function(a){b.f(a,function(c){var f=c[0],e=c[1],d=f+","+e,a=i;if(e||f)a=b.W(i);b.M(a,v[d]);b.qb(a,"hidden");b.s(a,"absolute");B.Ne(a);n[d]=a;b.z(a,!l)})})}function w(){var b=this,c=0;l.call(b,0,v);b.Nb=function(d,b){if(b-c>i){c=b;a&&a.cc(b);g&&g.cc(b)}};b.ad=r}f.Me=function(){var a=0,b=u.vb,d=b.length;if(x)a=y++%d;else a=c.floor(c.random()*d);b[a]&&(b[a].pb=a);return b[a]};f.Oe=function(w,x,k,l,b){r=b;b=j(b,i);var h=l.Cd,e=k.Cd;h["no-image"]=!l.Xb;e["no-image"]=!k.Xb;var m=h,o=e,u=b,d=b.pc||j({},i);if(!b.Vb){m=e;o=h}var t=d.Ob||0;g=new p(n,o,d,c.max(t-d.eb,0),s,q);a=new p(n,m,u,c.max(d.eb-t,0),s,q);g.cc(0);a.cc(0);v=c.max(g.cd,a.cd);f.pb=w};f.ub=function(){n.ub();g=h;a=h};f.gf=function(){var b=h;if(a)b=new w;return b};if(b.bc()||b.wd()||z&&b.hf()<537)i=16;m.call(f);l.call(f,-1e7,1e7)},j=function(p,fc){var o=this;function Bc(){var a=this;l.call(a,-1e8,2e8);a.df=function(){var b=a.yb(),d=c.floor(b),f=t(d),e=b-c.floor(b);return{pb:f,cf:d,Cb:e}};a.Nb=function(b,a){var d=c.floor(a);if(d!=a&&a>b)d++;Tb(d,e);o.j(j.bf,t(a),t(b),a,b)}}function Ac(){var a=this;l.call(a,0,0,{hc:r});b.f(A,function(b){D&1&&b.Yd(r);a.tc(b);b.Ob(kb/bc)})}function zc(){var a=this,b=Ub.ib;l.call(a,-1,2,{K:d.Jb,be:{Cb:Zb},hc:r},b,{Cb:1},{Cb:-2});a.ac=b}function mc(n,m){var b=this,d,f,g,i,c;l.call(b,-1e8,2e8,{ud:100});b.td=function(){O=e;R=h;o.j(j.We,t(w.X()),w.X())};b.rd=function(){O=k;i=k;var a=w.df();o.j(j.Ve,t(w.X()),w.X());!a.Cb&&Dc(a.cf,s)};b.Nb=function(j,h){var b;if(i)b=c;else{b=f;if(g){var e=h/g;b=a.Ue(e)*(f-d)+d}}w.gb(b)};b.Wb=function(a,e,c,h){d=a;f=e;g=c;w.gb(a);b.gb(0);b.od(c,h)};b.Te=function(a){i=e;c=a;b.pd(a,h,e)};b.Se=function(a){c=a};w=new Bc;w.Qc(n);w.Qc(m)}function oc(){var c=this,a=Xb();b.L(a,0);b.O(a,"pointerEvents","none");c.ib=a;c.Ne=function(c){b.B(a,c);b.z(a)};c.ub=function(){b.P(a);b.nc(a)}}function xc(n,f){var d=this,q,N,v,i,y=[],x,C,W,H,S,F,g,w,p;l.call(d,-u,u+1,{});function E(a){q&&q.kd();T(n,a,0);F=e;q=new J.N(n,J,b.Od(b.l(n,"idle"))||lc,!I);q.gb(0)}function Z(){q.gc<J.gc&&E()}function O(p,r,n){if(!H){H=e;if(i&&n){var g=n.width,c=n.height,m=g,l=c;if(g&&c&&a.xb){if(a.xb&3&&(!(a.xb&4)||g>L||c>K)){var h=k,q=L/K*c/g;if(a.xb&1)h=q>1;else if(a.xb&2)h=q<1;m=h?g*K/c:L;l=h?K:c*L/g}b.k(i,m);b.m(i,l);b.F(i,(K-l)/2);b.D(i,(L-m)/2)}b.s(i,"absolute");o.j(j.Wd,f)}}b.P(r);p&&p(d)}function Y(b,c,e,g){if(g==R&&s==f&&I)if(!Cc){var a=t(b);B.Oe(a,f,c,d,e);c.Nd();U.Ob(a-U.yd()-1);U.gb(a);z.Wb(b,b,0)}}function bb(b){if(b==R&&s==f){if(!g){var a=h;if(B)if(B.pb==f)a=B.gf();else B.ub();Z();g=new vc(n,f,a,q);g.jd(p)}!g.ld()&&g.Ec()}}function G(e,i,l){if(e==f){if(e!=i)A[i]&&A[i].nd();else!l&&g&&g.Ze();p&&p.Tb();var m=R=b.U();d.Ab(b.I(h,bb,m))}else{var k=c.min(f,e),j=c.max(f,e),o=c.min(j-k,k+r-j),n=u+a.ff-1;(!S||o<=n)&&d.Ab()}}function db(){if(s==f&&g){g.tb();p&&p.jf();p&&p.kf();g.Jd()}}function eb(){s==f&&g&&g.tb()}function ab(a){!P&&o.j(j.Qe,f,a)}function Q(){p=w.pInstance;g&&g.jd(p)}d.Ab=function(c,a){a=a||v;if(y.length&&!H){b.z(a);if(!W){W=e;o.j(j.Pe,f);b.f(y,function(a){if(!b.v(a,"src")){a.src=b.l(a,"src2")||"";b.V(a,a["display-origin"])}})}b.Vd(y,i,b.I(h,O,c,a))}else O(c,a)};d.xe=function(){var j=f;if(a.Uc<0)j-=r;var e=j+a.Uc*tc;if(D&2)e=t(e);if(!(D&1)&&!ib)e=c.max(0,c.min(e,r-u));if(e!=f){if(B){var g=B.Me(r);if(g){var k=R=b.U(),i=A[t(e)];return i.Ab(b.I(h,Y,e,i,g,k),v)}}cb(e)}else if(a.wb){d.nd();G(f,f)}};d.Dc=function(){G(f,f,e)};d.nd=function(){p&&p.jf();p&&p.kf();d.Jc();g&&g.ye();g=h;E()};d.Nd=function(){b.P(n)};d.Jc=function(){b.z(n)};d.ze=function(){p&&p.Tb()};function T(a,d,f,c){if(b.v(a,"jssor-slider"))return;if(!F){if(a.tagName=="IMG"){y.push(a);if(!b.v(a,"src")){S=e;a["display-origin"]=b.V(a);b.P(a)}}var g=b.Xd(a);if(g){var h=new Image;b.l(h,"src2",g);y.push(h)}if(f){c=a.style.pointerEvents||b.qc(a);!c&&b.O(a,"pointerEvents",a.tagName=="A"?"all":"none");b.L(a,(b.L(a)||0)+1);b.sc(a,b.sc(a)||0);b.oc(a,b.oc(a)||0);b.rb(a,{S:0})}}var j=b.dc(a);b.f(j,function(g){var j=g.tagName,l=b.l(g,"u");if(l=="player"&&!w){w=g;if(w.pInstance)Q();else b.c(w,"dataavailable",Q)}if(l=="caption"){if(d){b.Nc(g,b.l(g,"to"));b.Ce(g,b.l(g,"bf"));b.l(g,"3d")&&b.De(g,"preserve-3d")}else if(!b.sd()){var h=b.W(g,k,e);b.fc(h,g,a);b.zb(g,a);g=h;d=e}}else if(!F&&!f&&!i){if(j=="A"){if(b.l(g,"u")=="image")i=b.xf(g,"IMG");else i=b.q(g,"image",e);if(i){x=g;b.V(x,"block");b.M(x,V);C=b.W(x,e);b.s(x,"relative");b.Eb(C,0);b.O(C,"backgroundColor","#000")}}else if(j=="IMG"&&b.l(g,"u")=="image")i=g;if(i){i.border=0;b.M(i,V)}}T(g,d,f+1,c)})}d.kc=function(c,b){var a=u-b;Zb(N,a)};d.pb=f;m.call(d);b.nf(n,b.l(n,"p"));b.Ee(n,b.l(n,"po"));var M=b.q(n,"thumb",e);if(M){d.Ae=b.W(M);b.P(M)}b.z(n);v=b.W(gb);b.L(v,1e3);b.c(n,"click",ab);E(e);d.Xb=i;d.Kc=C;d.Cd=n;d.ac=N=n;b.B(N,v);o.Gb(203,G);o.Gb(28,eb);o.Gb(24,db)}function vc(y,f,p,q){var a=this,m=0,u=0,g,h,d,c,i,t,r,n=A[f];l.call(a,0,0);function v(){b.nc(N);cc&&i&&n.Kc&&b.B(N,n.Kc);b.z(N,!i&&n.Xb)}function w(){a.Ec()}function x(b){r=b;a.tb();a.Ec()}a.Ec=function(){var b=a.yb();if(!C&&!O&&!r&&s==f){if(!b){if(g&&!i){i=e;a.Jd(e);o.j(j.Be,f,m,u,g,c)}v()}var k,p=j.Mc;if(b!=c)if(b==d)k=c;else if(b==h)k=d;else if(!b)k=h;else k=a.md();o.j(p,f,b,m,h,d,c);var l=I&&(!E||F);if(b==c)(d!=c&&!(E&12)||l)&&n.xe();else(l||b!=d)&&a.od(k,w)}};a.Ze=function(){d==c&&d==a.yb()&&a.gb(h)};a.ye=function(){B&&B.pb==f&&B.ub();var b=a.yb();b<c&&o.j(j.Mc,f,-b-1,m,h,d,c)};a.Jd=function(a){p&&b.qb(lb,a&&p.ad.Hf?"":"hidden")};a.kc=function(b,a){if(i&&a>=g){i=k;v();n.Jc();B.ub();o.j(j.He,f,m,u,g,c)}o.j(j.we,f,a,m,h,d,c)};a.jd=function(a){if(a&&!t){t=a;a.Gb($JssorPlayer$.fe,x)}};p&&a.tc(p);g=a.rc();a.tc(q);h=g+q.Vc;c=a.rc();d=I?g+q.Wc:c}function Kb(a,c,d){b.D(a,c);b.F(a,d)}function Zb(c,b){var a=x>0?x:fb,d=zb*b*(a&1),e=Ab*b*(a>>1&1);Kb(c,d,e)}function Pb(){qb=O;Ib=z.md();G=w.X()}function gc(){Pb();if(C||!F&&E&12){z.tb();o.j(j.Ke)}}function ec(f){if(!C&&(F||!(E&12))&&!z.ld()){var d=w.X(),b=c.ceil(G);if(f&&c.abs(H)>=a.Yc){b=c.ceil(d);b+=jb}if(!(D&1))b=c.min(r-u,c.max(b,0));var e=c.abs(b-d);e=1-c.pow(1-e,5);if(!P&&qb)z.Zd(Ib);else if(d==b){tb.ze();tb.Dc()}else z.Wb(d,b,e*Vb)}}function Hb(a){!b.l(b.ic(a),"nodrag")&&b.Kb(a)}function rc(a){Yb(a,1)}function Yb(a,c){a=b.Md(a);var i=b.ic(a);if(!M&&!b.l(i,"nodrag")&&sc()&&(!c||a.touches.length==1)){C=e;yb=k;R=h;b.c(g,c?"touchmove":"mousemove",Bb);b.U();P=0;gc();if(!qb)x=0;if(c){var f=a.touches[0];ub=f.clientX;vb=f.clientY}else{var d=b.id(a);ub=d.x;vb=d.y}H=0;hb=0;jb=0;o.j(j.af,t(G),G,a)}}function Bb(d){if(C){d=b.Md(d);var f;if(d.type!="mousemove"){var l=d.touches[0];f={x:l.clientX,y:l.clientY}}else f=b.id(d);if(f){var j=f.x-ub,k=f.y-vb;if(c.floor(G)!=G)x=x||fb&M;if((j||k)&&!x){if(M==3)if(c.abs(k)>c.abs(j))x=2;else x=1;else x=M;if(ob&&x==1&&c.abs(k)-c.abs(j)>3)yb=e}if(x){var a=k,i=Ab;if(x==1){a=j;i=zb}if(!(D&1)){if(a>0){var g=i*s,h=a-g;if(h>0)a=g+c.sqrt(h)*5}if(a<0){var g=i*(r-u-s),h=-a-g;if(h>0)a=-g-c.sqrt(h)*5}}if(H-hb<-2)jb=0;else if(H-hb>2)jb=-1;hb=H;H=a;sb=G-H/i/(Y||1);if(H&&x&&!yb){b.Kb(d);if(!O)z.Te(sb);else z.Se(sb)}}}}}function bb(){qc();if(C){C=k;b.U();b.R(g,"mousemove",Bb);b.R(g,"touchmove",Bb);P=H;z.tb();var a=w.X();o.j(j.Bf,t(a),a,t(G),G);E&12&&Pb();ec(e)}}function jc(c){if(P){b.Je(c);var a=b.ic(c);while(a&&v!==a){a.tagName=="A"&&b.Kb(c);try{a=a.parentNode}catch(d){break}}}}function Jb(a){A[s];s=t(a);tb=A[s];Tb(a);return s}function Dc(a,b){x=0;Jb(a);o.j(j.Cf,t(a),b)}function Tb(a,c){wb=a;b.f(S,function(b){b.Fc(t(a),a,c)})}function sc(){var b=j.Zc||0,a=X;if(ob)a&1&&(a&=1);j.Zc|=a;return M=a&~b}function qc(){if(M){j.Zc&=~X;M=0}}function Xb(){var a=b.ob();b.M(a,V);b.s(a,"absolute");return a}function t(a){return(a%r+r)%r}function kc(b,d){if(d)if(!D){b=c.min(c.max(b+wb,0),r-u);d=k}else if(D&2){b=t(b+wb);d=k}cb(b,a.xc,d)}function xb(){b.f(S,function(a){a.wc(a.ec.If<=F)})}function hc(){if(!F){F=1;xb();if(!C){E&12&&ec();E&3&&A[s]&&A[s].Dc()}}}function Ec(){if(F){F=0;xb();C||!(E&12)||gc()}}function ic(){V={db:L,Z:K,i:0,g:0};b.f(T,function(a){b.M(a,V);b.s(a,"absolute");b.qb(a,"hidden");b.P(a)});b.M(gb,V)}function ab(b,a){cb(b,a,e)}function cb(g,f,l){if(Rb&&(!C&&(F||!(E&12))||a.Lc)){O=e;C=k;z.tb();if(f==i)f=Vb;var d=Cb.yb(),b=g;if(l){b=d+g;if(g>0)b=c.ceil(b);else b=c.floor(b)}if(D&2)b=t(b);if(!(D&1))b=c.max(0,c.min(b,r-u));var j=(b-d)%r;b=d+j;var h=d==b?0:f*c.abs(j);h=c.min(h,f*u*1.5);z.Wb(d,b,h||1)}}o.pf=cb;o.pd=function(){if(!I){I=e;A[s]&&A[s].Dc()}};o.Ud=function(){return P};function W(){return b.k(y||p)}function nb(){return b.m(y||p)}o.hb=W;o.nb=nb;function Eb(c,d){if(c==i)return b.k(p);if(!y){var a=b.ob(g);b.qc(a,b.qc(p));b.Ib(a,b.Ib(p));b.V(a,"block");b.s(a,"relative");b.F(a,0);b.D(a,0);b.qb(a,"visible");y=b.ob(g);b.s(y,"absolute");b.F(y,0);b.D(y,0);b.k(y,b.k(p));b.m(y,b.m(p));b.Nc(y,"0 0");b.B(y,a);var h=b.dc(p);b.B(p,y);b.O(p,"backgroundImage","");b.f(h,function(c){b.B(b.l(c,"noscale")?p:a,c);b.l(c,"autocenter")&&Lb.push(c)})}Y=c/(d?b.m:b.k)(y);b.Fe(y,Y);var f=d?Y*W():c,e=d?c:Y*nb();b.k(p,f);b.m(p,e);b.f(Lb,function(a){var c=b.Pd(b.l(a,"autocenter"));b.Td(a,c)})}o.Sd=Eb;o.gd=function(a){var d=c.ceil(t(kb/bc)),b=t(a-s+d);if(b>u){if(a-s>r/2)a-=r;else if(a-s<=-r/2)a+=r}else a=s+b-d;return a};m.call(o);o.ib=p=b.mb(p);var a=b.u({xb:0,ff:1,yc:1,Gc:0,uc:k,wb:1,Bb:e,Lc:e,Uc:1,vd:3e3,fd:1,xc:500,Ue:d.ee,Yc:20,ed:0,o:1,Cc:0,te:1,Ac:1,bd:1},fc);a.Bb=a.Bb&&b.ef();if(a.se!=i)a.vd=a.se;if(a.re!=i)a.Cc=a.re;var fb=a.Ac&3,tc=(a.Ac&4)/-4||1,mb=a.ve,J=b.u({N:q,Bb:a.Bb},a.Ff);J.vb=J.vb||J.Gf;var Fb=a.oe,Z=a.me,eb=a.le,Q=!a.te,y,v=b.q(p,"slides",Q),gb=b.q(p,"loading",Q)||b.ob(g),Nb=b.q(p,"navigator",Q),dc=b.q(p,"arrowleft",Q),ac=b.q(p,"arrowright",Q),Mb=b.q(p,"thumbnavigator",Q),pc=b.k(v),nc=b.m(v),V,T=[],uc=b.dc(v);b.f(uc,function(a){a.tagName=="DIV"&&!b.l(a,"u")&&T.push(a);b.L(a,(b.L(a)||0)+1)});var s=-1,wb,tb,r=T.length,L=a.je||pc,K=a.ge||nc,Wb=a.ed,zb=L+Wb,Ab=K+Wb,bc=fb&1?zb:Ab,u=c.min(a.o,r),lb,x,M,yb,S=[],Qb,Sb,Ob,cc,Cc,I,E=a.fd,lc=a.vd,Vb=a.xc,rb,ib,kb,Rb=u<r,D=Rb?a.wb:0,X,P,F=1,O,C,R,ub=0,vb=0,H,hb,jb,Cb,w,U,z,Ub=new oc,Y,Lb=[];if(r){if(a.Bb)Kb=function(a,c,d){b.rb(a,{kb:c,lb:d})};I=a.uc;o.ec=fc;ic();b.v(p,"jssor-slider",e);b.L(v,b.L(v)||0);b.s(v,"absolute");lb=b.W(v,e);b.fc(lb,v);if(mb){cc=mb.Jf;rb=mb.N;ib=u==1&&r>1&&rb&&(!b.sd()||b.Dd()>=8)}kb=ib||u>=r||!(D&1)?0:a.Cc;X=(u>1||kb?fb:-1)&a.bd;var Gb=v,A=[],B,N,Db=b.Ye(),ob=Db.Xe,G,qb,Ib,sb;Db.qd&&b.O(Gb,Db.qd,([h,"pan-y","pan-x","none"])[X]||"");U=new zc;if(ib)B=new rb(Ub,L,K,mb,ob);b.B(lb,U.ac);b.qb(v,"hidden");N=Xb();b.O(N,"backgroundColor","#000");b.Eb(N,0);b.fc(N,Gb.firstChild,Gb);for(var db=0;db<T.length;db++){var wc=T[db],yc=new xc(wc,db);A.push(yc)}b.P(gb);Cb=new Ac;z=new mc(Cb,U);b.c(v,"click",jc,e);b.c(p,"mouseout",b.Pb(hc,p));b.c(p,"mouseover",b.Pb(Ec,p));if(X){b.c(v,"mousedown",Yb);b.c(v,"touchstart",rc);b.c(v,"dragstart",Hb);b.c(v,"selectstart",Hb);b.c(g,"mouseup",bb);b.c(g,"touchend",bb);b.c(g,"touchcancel",bb);b.c(f,"blur",bb)}E&=ob?10:5;if(Nb&&Fb){Qb=new Fb.N(Nb,Fb,W(),nb());S.push(Qb)}if(Z&&dc&&ac){Z.wb=D;Z.o=u;Sb=new Z.N(dc,ac,Z,W(),nb());S.push(Sb)}if(Mb&&eb){eb.Gc=a.Gc;Ob=new eb.N(Mb,eb);S.push(Ob)}b.f(S,function(a){a.Bc(r,A,gb);a.Gb(n.Qb,kc)});b.O(p,"visibility","visible");Eb(W());xb();a.yc&&b.c(g,"keydown",function(b){if(b.keyCode==37)ab(-a.yc);else b.keyCode==39&&ab(a.yc)});var pb=a.Gc;if(!(D&1))pb=c.max(0,c.min(pb,r-u));z.Wb(pb,pb,0)}};j.Qe=21;j.af=22;j.Bf=23;j.We=24;j.Ve=25;j.Pe=26;j.Wd=27;j.Ke=28;j.bf=202;j.Cf=203;j.Be=206;j.He=207;j.we=208;j.Mc=209;var n={Qb:1},r=function(d,C){var f=this;m.call(f);d=b.mb(d);var s,A,z,r,l=0,a,o,j,w,x,i,g,q,p,B=[],y=[];function v(a){a!=-1&&y[a].Rc(a==l)}function t(a){f.j(n.Qb,a*o)}f.ib=d;f.Fc=function(a){if(a!=r){var d=l,b=c.floor(a/o);l=b;r=a;v(d);v(b)}};f.wc=function(a){b.z(d,a)};var u;f.Bc=function(D){if(!u){s=c.ceil(D/o);l=0;var n=q+w,r=p+x,m=c.ceil(s/j)-1;A=q+n*(!i?m:j-1);z=p+r*(i?m:j-1);b.k(d,A);b.m(d,z);for(var f=0;f<s;f++){var C=b.qf();b.Le(C,f+1);var k=b.Sc(g,"numbertemplate",C,e);b.s(k,"absolute");var v=f%(m+1);b.D(k,!i?n*v:f%j*n);b.F(k,i?r*v:c.floor(f/(m+1))*r);b.B(d,k);B[f]=k;a.Db&1&&b.c(k,"click",b.I(h,t,f));a.Db&2&&b.c(k,"mouseover",b.Pb(b.I(h,t,f),k));y[f]=b.Zb(k)}u=e}};f.ec=a=b.u({zc:10,vc:10,Fb:1,Db:1},C);g=b.q(d,"prototype");q=b.k(g);p=b.m(g);b.zb(g,d);o=a.Ed||1;j=a.fb||1;w=a.zc;x=a.vc;i=a.Fb-1;a.Sb==k&&b.v(d,"noscale",e);a.ab&&b.v(d,"autocenter",a.ab)},t=function(a,g,i){var c=this;m.call(c);var r,d,f,j;b.k(a);b.m(a);var p,o;function l(a){c.j(n.Qb,a,e)}function t(c){b.z(a,c);b.z(g,c)}function s(){p.Tb(i.wb||d>0);o.Tb(i.wb||d<r-i.o)}c.Fc=function(b,a,c){if(c)d=a;else{d=b;s()}};c.wc=t;var q;c.Bc=function(c){r=c;d=0;if(!q){b.c(a,"click",b.I(h,l,-j));b.c(g,"click",b.I(h,l,j));p=b.Zb(a);o=b.Zb(g);q=e}};c.ec=f=b.u({Ed:1},i);j=f.Ed;if(f.Sb==k){b.v(a,"noscale",e);b.v(g,"noscale",e)}if(f.ab){b.v(a,"autocenter",f.ab);b.v(g,"autocenter",f.ab)}},p=function(g,B){var i=this,z,p,a,v=[],x,w,d,q,r,u,t,o,s,f,l;m.call(i);g=b.mb(g);function A(o,f){var g=this,c,m,k;function q(){m.Rc(p==f)}function j(e){if(e||!s.Ud()){var a=d-f%d,b=s.gd((f+a)/d-1),c=b*d+d-a;i.j(n.Qb,c)}}g.pb=f;g.xd=q;k=o.Ae||o.Xb||b.ob();g.ac=c=b.Sc(l,"thumbnailtemplate",k,e);m=b.Zb(c);a.Db&1&&b.c(c,"click",b.I(h,j,0));a.Db&2&&b.c(c,"mouseover",b.Pb(b.I(h,j,1),c))}i.Fc=function(b,e,f){var a=p;p=b;a!=-1&&v[a].xd();v[b].xd();!f&&s.pf(s.gd(c.floor(e/d)))};i.wc=function(a){b.z(g,a)};var y;i.Bc=function(D,C){if(!y){z=D;c.ceil(z/d);p=-1;o=c.min(o,C.length);var h=a.Fb&1,m=u+(u+q)*(d-1)*(1-h),l=t+(t+r)*(d-1)*h,B=m+(m+q)*(o-1)*h,n=l+(l+r)*(o-1)*(1-h);b.s(f,"absolute");b.qb(f,"hidden");a.ab&1&&b.D(f,(x-B)/2);a.ab&2&&b.F(f,(w-n)/2);b.k(f,B);b.m(f,n);var i=[];b.f(C,function(l,g){var j=new A(l,g),e=j.ac,a=c.floor(g/d),k=g%d;b.D(e,(u+q)*k*(1-h));b.F(e,(t+r)*k*h);if(!i[a]){i[a]=b.ob();b.B(f,i[a])}b.B(i[a],e);v.push(j)});var E=b.u({uc:k,Lc:k,je:m,ge:l,ed:q*h+r*(1-h),Yc:12,xc:200,fd:1,Ac:a.Fb,bd:a.ce||a.Df?0:a.Fb},a);s=new j(g,E);y=e}};i.ec=a=b.u({zc:0,vc:0,o:1,Fb:1,ab:3,Db:1},B);x=b.k(g);w=b.m(g);f=b.q(g,"slides",e);l=b.q(f,"prototype");u=b.k(l);t=b.m(l);b.zb(l,f);d=a.fb||1;q=a.zc;r=a.vc;o=a.o;a.Sb==k&&b.v(g,"noscale",e)};function q(e,d,c){var a=this;l.call(a,0,c);a.kd=b.Oc;a.Vc=0;a.Wc=c}jssor_1_slider_init=function(){var h=[{Ub:1200,x:-.3,lc:{g:[.3,.7]},K:{g:d.Kd,A:d.Jb},A:2},{Ub:1200,x:.3,Vb:e,K:{g:d.Kd,A:d.Jb},A:2}],i={uc:e,ve:{N:s,vb:h,rf:1},me:{N:t},oe:{N:r},le:{N:p,o:1,Cc:0,ce:e}},g=new j("jssor_1",i);function a(){var b=g.ib.parentNode.clientWidth;if(b){b=c.min(b,600);g.Sd(b)}else f.setTimeout(a,30)}a();b.c(f,"load",a);b.c(f,"resize",a);b.c(f,"orientationchange",a)}})(window,document,Math,null,true,false)
</script>
					<style>
.jssorb01 {
	position: absolute
}

.jssorb01 div, .jssorb01 div:hover, .jssorb01 .av {
	position: absolute;
	width: 12px;
	height: 12px;
	filter: alpha(opacity = 70);
	opacity: .7;
	overflow: hidden;
	cursor: pointer;
	border: #000 1px solid
}

.jssorb01 div {
	background-color: gray
}

.jssorb01 div:hover, .jssorb01 .av:hover {
	background-color: #d3d3d3
}

.jssorb01 .av {
	background-color: #fff
}

.jssorb01 .dn, .jssorb01 .dn:hover {
	background-color: #555
}

.jssora05l, .jssora05r {
	display: block;
	position: absolute;
	width: 40px;
	height: 40px;
	cursor: pointer;
	background: url('images/a17.png') no-repeat;
	overflow: hidden
}

.jssora05l {
	background-position: -10px -40px
}

.jssora05r {
	background-position: -70px -40px
}

.jssora05l:hover {
	background-position: -130px -40px
}

.jssora05r:hover {
	background-position: -190px -40px
}

.jssora05l.jssora05ldn {
	background-position: -250px -40px
}

.jssora05r.jssora05rdn {
	background-position: -310px -40px
}

.jssora05l.jssora05lds {
	background-position: -10px -40px;
	opacity: .3;
	pointer-events: none
}

.jssora05r.jssora05rds {
	background-position: -70px -40px;
	opacity: .3;
	pointer-events: none
}

.jssort09-600-45 .p {
	position: absolute;
	top: 0;
	left: 0;
	width: 600px;
	height: 45px
}

.jssort09-600-45 .t {
	font-family: verdana;
	font-weight: normal;
	position: absolute;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	color: #fff;
	line-height: 45px;
	font-size: 20px;
	padding-left: 10px
}
</style>
					<div id="jssor_1"
						style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden; visibility: hidden;">
						<!-- Loading Screen -->
						<div data-u="loading"
							style="position: absolute; top: 0px; left: 0px; background-color: rgba(0, 0, 0, 0.7);">
							<div
								style="filter: alpha(opacity = 70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
							<div
								style="position: absolute; display: block; background: url('images/loading.gif') no-repeat center center; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
						</div>
						<div data-u="slides"
							style="cursor: default; position: relative; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden;">
							<div>
								<img data-u="image" src="resources/images/port1.jpg" />
								<div data-u="thumb">
									<h5>Post: Opened on 1870; 145 years ago</h5>
								</div>
							</div>
							<div>
								<img data-u="image" src="resources/images/port2.jpg" />
								<div data-u="thumb">
									<h5>Post: Located in 15 Strand Road, Kolkata: 700001</h5>
								</div>
							</div>
							<a data-u="any" href="http://www.jssor.com" style="display: none">Banner
								Slider</a>
							<div>
								<img data-u="image" src="resources/images/port3.jpg" />
								<div data-u="thumb">
									<h5>Post: HDC Administrative Building</h5>
								</div>
							</div>
							<div>
								<img data-u="image" src="resources/images/port4.jpg" />
								<div data-u="thumb">
									<h5>Post: Ship entering HDC through Hooghly river</h5>
								</div>
							</div>
							<div>
								<img data-u="image" src="resources/images/port5.jpg" />
								<div data-u="thumb">
									<h5>Post: Iron Ore Loading to Vessel</h5>
								</div>
							</div>
							<div>
								<img data-u="image" src="resources/images/port6.jpg" />
								<div data-u="thumb">
									<h5>Post: Coal discharging from Vessel</h5>
								</div>
							</div>
							<div>
								<img data-u="image" src="resources/images/port7.jpg" />
								<div data-u="thumb">
									<h5>Post: HDC Container Storage Area</h5>
								</div>
							</div>
							<div>
								<img data-u="image" src="resources/images/port8.jpg" />
								<div data-u="thumb">
									<h5>Post: Dry Bulk Hipping Operation</h5>
								</div>
							</div>
							<div>
								<img data-u="image" src="resources/images/port9.jpg" />
								<div data-u="thumb">
									<h5>Post: Dry Bulk Loading Operation</h5>
								</div>
							</div>
						</div>
						<!-- Thumbnail Navigator -->
						<div data-u="thumbnavigator" class="jssort09-600-45"
							style="position: absolute; bottom: 0px; left: 0px; width:650px; height: 45px;">
							<div
								style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; background-color: #000; filter: alpha(opacity = 40.0); opacity: 0.4;"></div>
							<!-- Thumbnail Item Skin Begin -->
							<div data-u="slides" style="cursor: default;">
								<div data-u="prototype" class="p">
									<div data-u="thumbnailtemplate" class="t"></div>
								</div>
							</div>
							<!-- Thumbnail Item Skin End -->
						</div>
						<!-- Bullet Navigator -->
						<div data-u="navigator" class="jssorb01"
							style="bottom: 16px; right: 16px;">
							<div data-u="prototype" style="width: 12px; height: 12px;"></div>
						</div>
						<!-- Arrow Navigator -->
						<span data-u="arrowleft" class="jssora05l"
							style="top: 0px; left: 8px; width: 40px; height: 40px;"
							data-autocenter="2"></span> <span data-u="arrowright"
							class="jssora05r"
							style="top: 0px; right: 8px; width: 40px; height: 40px;"
							data-autocenter="2"></span>
					</div>
					<script type="text/javascript">jssor_1_slider_init();</script>
					<p>
						In the year 1999, Haldia Dock Complex initiated development of an
						integrated software solution basket to become a modern ICT enabled
						& market driven port. Came July 2003 and Haldia Dock Complex
						emerged as the <b>premier ICT enabled </b> port of India with the
						help of NIC-WBSC as their ICT partner. Since then the commissioned
						solution has become part and parcel of the port business. Haldia
						port is now the leading ICT enabled port of India and a <b>'Model'</b>
						for other ports in ICT implementation.
					</p>
					
					<p>
						A dedicated team of IT professionals from <a target="_blank"
							href="http://www.nic.in/projects/port-operationsand-management-system-poms-kolkata-port-trust">
							National Informatics Centre</a>, <a target="_blank"
							href="http://nicwb.nic.in/html/egkoldock.htm">West Bengal
							State Centre</a> have been engaged with the port business domain for
						more than 15 years to enrich and add value by adopting 'Standard
						Practices' reflected in this software solution. Rollout of this
						solution has been divided into two parts - operational segment
						known as <b>'Port Operation Management System (POMS)'</b> and
						standard management functions part termed as <b>'Enterprise
							Resource Planning (ERP)'</b>. This solution is fully operational and
						in use at <a target="_blank"
							href="http://www.kolkataporttrust.gov.in/index.php?layout=3&lang=1">Haldia</a>,
						<a target="_blank"
							href="http://www.kolkataporttrust.gov.in/index.php?layout=2&lang=1">Kolkata</a>,
						<a target="_blank" href="http://www.ennoreport.gov.in/">Ennore</a>
						and <a target="_blank" href="http://www.chennaiport.gov.in/">Chennai</a>.
					</p>
					
				</div>
			</div>
		</div>
		
	</div>
</body>

</html>
