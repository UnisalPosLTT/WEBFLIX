<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="shortcut icon" href="https://assets.nflxext.com/us/ffe/siteui/common/icons/nficon2016.ico"/>
        <title>UNISAL - Webflix</title>
        <style type="text/css">
            @import url(https://fonts.googleapis.com/css?family=Roboto:300);

            .login-page {
                width: 360px;
                padding: 8% 0 0;
                margin: auto;
            }
            .form {
                position: relative;
                z-index: 1;
                background: #FFFFFF;
                max-width: 360px;
                margin: 0 auto 100px;
                padding: 45px;
                text-align: center;
                box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
                margin-top: 10%
            }
            .form input {
                font-family: "Roboto", sans-serif;
                outline: 0;
                background: #f2f2f2;
                width: 100%;
                border: 0;
                margin: 0 0 15px;
                padding: 15px;
                box-sizing: border-box;
                font-size: 14px;
            }
            .form button {
                font-family: "Roboto", sans-serif;
                text-transform: uppercase;
                outline: 0;
                background: #d60909;
                width: 100%;
                border: 0;
                padding: 15px;
                color: #FFFFFF;
                font-size: 14px;
                -webkit-transition: all 0.3 ease;
                transition: all 0.3 ease;
                cursor: pointer;
            }
            .form button cinza {
                font-family: "Roboto", sans-serif;
                text-transform: uppercase;
                outline: 0;
                background: #4a4949;
                width: 100%;
                border: 0;
                padding: 15px;
                color: #FFFFFF;
                font-size: 14px;
                -webkit-transition: all 0.3 ease;
                transition: all 0.3 ease;
                cursor: pointer;
            }
            .form button:hover,.form button:active,.form button:focus {
                background: #d60909c2;
            }
            
            .cinza {
            	background: #4a4949 !important;
            }
            
            .cinza:hover {
            	background: #c5c5c5 !important;
            }
            .form .message {
                margin: 15px 0 0;
                color: #b3b3b3;
                font-size: 12px;
            }
            
            .btn-primary:active {
    			color: #fff !important;
    			background-color: #4a4949 !important;
    			border-color: #4a4949 !important;
			}

            .form .message a {
                color: #4CAF50;
                text-decoration: none;
            }
            .form .register-form {
                display: none;
            }
            .container {
                position: relative;
                z-index: 1;
                max-width: 300px;
                margin: 0 auto;
            }
            .container:before, .container:after {
                content: "";
                display: block;
                clear: both;
            }
            .container .info {
                margin: 50px auto;
                text-align: center;
            }
            .container .info h1 {
                margin: 0 0 15px;
                padding: 0;
                font-size: 36px;
                font-weight: 300;
                color: #1a1a1a;
            }
            .container .info span {
                color: #4d4d4d;
                font-size: 12px;
            }
            .container .info span a {
                color: #000000;
                text-decoration: none;
            }
            .container .info span .fa {
                color: #EF3B3A;
            }
            body {
            	background-color: black;
                background: black; /* fallback for old browsers */
                background: black;
                background: black;
                background: black;
                background: black;
                font-family: "Roboto", sans-serif;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;      
            }
        </style>
    </head>
    <body>
       
               	
            <div class="form">
            
            	<h1><font color="red" size="7"><strong>WEBFLIX</strong></font></h1>
            	<form class="form-group" action="login" method="post">
		              	<div>
		                	<input type="text" class="form-control" name="login" placeholder="Usuário" required="" />
		              	</div>
		              	<div>
		                	<input type="password" class="form-control" name="senha" placeholder="Senha" required="" />
		              	</div>
		              	<div>
		                	<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		              	</div>
            	</form>
            	
            	<div>
                <form class="form-group" action="listaUsuarios" method="post">
				    <button type="submit" class="btn btn-lg btn-primary btn-block cinza">Usuários</button>
				</form>
				</div>
				
				<div>
				<form class="form-group" action="listaFilmes" method="post">
					<button type="submit" class="btn btn-lg btn-primary btn-block cinza">Filmes</button>
				</form>
				</div>
				
		 </div>
				
				
              
    </body>
</html>