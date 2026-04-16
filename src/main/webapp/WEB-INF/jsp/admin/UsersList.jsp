<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moradores</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        .back-btn {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-bottom: 20px;
        }

        .back-btn:hover {
            opacity: 0.9;
        }

        .create-form {
            margin-bottom: 28px;
            padding: 20px;
            border: 1px solid #e9e9e9;
            border-radius: 10px;
            background: #fafafa;
        }

        .create-form h2 {
            color: #333;
            font-size: 20px;
            margin-bottom: 16px;
        }

        .form-row {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 12px;
            margin-bottom: 12px;
        }

        .create-form input {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #d8d8d8;
            border-radius: 6px;
            font-size: 14px;
        }

        .create-form input:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 2px rgba(102, 126, 234, 0.15);
        }

        .submit-btn {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: #fff;
            border: none;
            padding: 10px 18px;
            border-radius: 6px;
            cursor: pointer;
            font-weight: 600;
        }

        .submit-btn:hover {
            opacity: 0.95;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href="${pageContext.request.contextPath}/admin/home" class="back-btn">← Voltar</a>

        <form class="create-form" method="POST" action="${pageContext.request.contextPath}/admin/moradores">
            <h2>Novo Morador</h2>
            <div class="form-row">
                <input type="text" name="name" placeholder="Nome completo" required>
                <input type="text" name="login" placeholder="Login" required>
                <input type="password" name="password" placeholder="Senha" required>
            </div>
            <button type="submit" class="submit-btn">Cadastrar morador</button>
        </form>

        <h1>Gerenciar Moradores</h1>
        <!-- Conteúdo será adicionado aqui -->
    </div>
</body>
</html>
