<%--
  Created by IntelliJ IDEA.
  User: mxp
  Date: 2018/12/7
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <style>
        .modal-body > div > p > span{
            display: inline-block;
            width: 100px;
        }
    </style>
</head>
<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">参数:</h4>
            </div>
            <div class="modal-body">
                <%--
                ?stationid=36310001&systemver=2.0&softver=1.0&machid=79f8e76a343954454100b46ab79cc64b&paramlist=
                --%>
                <div style="text-align: center">
                    <p>
                        <span>stationid</span>
                        :
                        <span>""</span>
                    </p>
                    <p>
                        <span>systemver</span>
                        :
                        <span>2.0</span>
                    </p>
                    <p>
                        <span>softver</span>
                        :
                        <span>1.0</span>
                    </p>
                    <p>
                        <span>machid</span>
                        :
                        <span>""</span>
                    </p>
                    <p>
                        <span>paramlist</span>
                        :
                        <span>""</span>
                    </p>
                    <p>
                        stationid=&systemver=2.0&softver=1.0&machid=& paramlist=
                    </p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


