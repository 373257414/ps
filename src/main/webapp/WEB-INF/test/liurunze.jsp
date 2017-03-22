<!DOCTYPE>
<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#one").css("background", "#bbffaa");
            $(".mini").css("background","#bbffaa");
        })
    </script>
    <style type="text/css">
        div, span, p {
            width: 140px;
            height: 140px;
            margin: 5px;
            background: #aaa;
            border: #000 1px solid;
            float: left;
            font-size: 17px;
            font-family: Verdana;
        }

        div.mini {
            width: 55px;
            height: 55px;
            background-color: #aaa;
            font-size: 12px;
        }

        div.hide {
            display: none;
        }
    </style>
</head>
<body>
<div class="one" id="one">
    id为one，class为one的div
    <div class="mini">class为mini的div</div>
</div>
<div class="one" id="two" title="test">
    id为two，class为one，title为test的div
    <div class="mini" title="other">class为mini，title为other的div</div>
    <div class="mini" title="test">class为mini，title为test的div</div>
</div>
<div class="one">
    <div class="mini">class为mini</div>
    <div class="mini">class为mini</div>
    <div class="mini">class为mini</div>
    <div class="mini"></div>
</div>
<div class="one">
    <div class="mini">class为mini</div>
    <div class="mini">class为mini</div>
    <div class="mini">class为mini</div>
    <div class="mini" title="tesst">class为mini，title为tesst的div</div>
</div>
<div style="display:none;" class="none">
    style的display为none的div
</div>
<div class="hide">class为hide的div</div>
<div>
    包含input的type为hidden的div<input type="hidden" size="8">
</div>
<span id="mover">正在执行动画的span元素</span>
</body>
</html>
