<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Administrador</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .container { max-width: 1200px; margin: 0 auto; }

        .header {
            background: white;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            margin-bottom: 40px;
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
            transition: background 0.3s;
        }

        .logout-btn:hover { background: #ff5252; }

        .main-content {
            background: white;
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        }

        .main-content h1 {
            text-align: center;
            color: #333;
            margin-bottom: 50px;
            font-size: 32px;
        }

        .buttons-grid {
            display: grid;
            grid-template-columns: repeat(2, minmax(240px, 1fr));
            gap: 24px;
        }

        .nav-button {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            padding: 28px 20px;
            border-radius: 10px;
            font-size: 18px;
            font-weight: 600;
            cursor: pointer;
            transition: transform 0.3s, box-shadow 0.3s;
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.3);
            text-decoration: none;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 88px;
            text-align: center;
            white-space: nowrap;
        }

        .nav-button:hover {
            transform: translateY(-5px);
            box-shadow: 0 15px 30px rgba(102, 126, 234, 0.5);
        }

        .nav-button:active { transform: translateY(-2px); }

        @media (max-width: 768px) {
            .header { flex-direction: column; gap: 20px; text-align: center; }
            .buttons-grid { grid-template-columns: 1fr; }
            .nav-button { width: 100%; white-space: normal; }
            .main-content { padding: 30px 20px; }
            .main-content h1 { font-size: 24px; margin-bottom: 30px; }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="user-info">
                <h2>${user.name}</h2>
                <p><strong>Login:</strong> ${user.login}</p>
                <span class="role">${user.role}</span>
            </div>
            <form method="POST" action="${pageContext.request.contextPath}/auth/logout" style="display: inline;">
                <button type="submit" class="logout-btn">Sair</button>
            </form>
        </div>

        <div class="main-content">
            <h1>Bem-vindo ao Painel Administrativo</h1>
            <div class="buttons-grid">
                <a href="${pageContext.request.contextPath}/admin/moradores" class="nav-button">Moradores</a>
                <a href="${pageContext.request.contextPath}/admin/colaboradores" class="nav-button">Colaboradores</a>
                <a href="${pageContext.request.contextPath}/admin/blocos" class="nav-button">Blocos</a>
                <a href="${pageContext.request.contextPath}/admin/administradores" class="nav-button">Administradores</a>
            </div>
        </div>
    </div>
</body>
</html>
