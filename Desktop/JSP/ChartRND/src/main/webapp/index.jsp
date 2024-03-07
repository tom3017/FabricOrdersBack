<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
        <title>SVG 바차트 만들기</title>
        <style type="text/css">
            body { font-size:20px }
        </style>
        <script type="text/javascript" src="chart.js"></script>
        <script type="text/javascript" src="index.js"></script>
    </head>
    <body onload="init()">
        <div style="display:flex;flex-direction:row;padding:10px;">
            <button ref="btnSetData">Random</button>
        </div>
        <div>
            <svg ref="svg" width="1000" height="600" style="background-color:#eee"></svg>
        </div>
    </body>
</html>