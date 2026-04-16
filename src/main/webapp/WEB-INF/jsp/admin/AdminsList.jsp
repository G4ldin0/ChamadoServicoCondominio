<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administradores</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .page-container { max-width: 1200px; margin: 0 auto; }

        .header {
            background: white;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            margin-bottom: 24px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .user-info { display: flex; flex-direction: column; gap: 5px; }
        .user-info h2 { color: #333; font-size: 20px; margin-bottom: 5px; }
        .user-info p { color: #666; font-size: 14px; }

        .user-info .role {
            display: inline-block;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 4px 12px;
            border-radius: 20px;
            font-size: 12px;
            font-weight: 600;
            margin-top: 5px;
            width: fit-content;
        }

        .logout-btn {
            background: #ff6b6b;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-weight: 600;
        }

        .logout-btn:hover { background: #ff5252; }

        .container {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        }

        h1 { color: #333; margin-bottom: 20px; }

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

        .back-btn:hover { opacity: 0.9; }
    </style>
</head>
<body>
    <div class="page-container">
        <%@ include file="/WEB-INF/jsp/admin/fragments/adminHeader.jspf" %>

        <div class="container">
            <a href="${pageContext.request.contextPath}/admin/home" class="back-btn">&larr; Voltar</a>
            <h1>Gerenciar Administradores</h1>
            <!-- Conteudo sera adicionado aqui -->
        </div>
    </div>
</body>
</html>
