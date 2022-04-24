<%-- 
    Document   : managerLoginScreen
    Created on : Mar 16, 2022, 7:46:44 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Login</title>
        <link rel="stylesheet" href="./style.css">

    </head>
    <body>
        <form action="FrontEnd" method="post" id="ManagerLogin" role="form" >    
        <div class="row">
            <div class="col-lg-3 col-md-2"></div>
            <div class="col-lg-6 col-md-8 login-box">
                <div class="col-lg-12 login-key">
                    <i class="fa fa-key" aria-hidden="true"></i>
                </div>
                <div class="col-lg-12 login-title">
                    Welcome! Login to your manager account
                </div>

                <div class="col-lg-12 login-form">
                    <div class="col-lg-12 login-form">
                        <form>
                            <div class="form-group">
                                <label class="form-control-label">Manager USERNAME</label>
                                <input type="text" name="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label class="form-control-label">PASSWORD</label>
                                <input type="password" name="password" class="form-control" >
                            </div>

                            <div class="col-lg-12 loginbttm">
                                <div class="col-lg-6 login-btm login-text">
                                </div>
                                <div class="col-lg-6 login-btm login-button">
                                    <button type="submit" class="btn btn-outline-primary">Manager Login</button>
                                    <input type="hidden" name="pageName" value="ManagerLogin"/>

                                </div>
                            </div>
                        </form>
                       
                    </div>
                </div>
                <div class="col-lg-3 col-md-2"></div>
            </div>
        </form>
    </body>
</html>
