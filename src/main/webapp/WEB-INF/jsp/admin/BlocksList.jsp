<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blocos</title>
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

        .create-form {
            margin-bottom: 28px;
            padding: 20px;
            border: 1px solid #e9e9e9;
            border-radius: 10px;
            background: #fafafa;
        }

        .create-form h2 { color: #333; font-size: 20px; margin-bottom: 16px; }

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

        .submit-btn:hover { opacity: 0.95; }

        .blocks-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 24px;
        }

        .blocks-table thead {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }

        .blocks-table th {
            padding: 12px;
            text-align: left;
            font-weight: 600;
        }

        .blocks-table tbody tr {
            border-bottom: 1px solid #e9e9e9;
            transition: background-color 0.2s;
        }

        .blocks-table tbody tr:hover {
            background-color: #f5f5f5;
        }

        .blocks-table td {
            padding: 12px;
            color: #333;
        }

        .empty-message {
            text-align: center;
            color: #999;
            padding: 30px;
            font-style: italic;
        }

        .action-link {
            text-decoration: none;
            cursor: pointer;
            margin-right: 10px;
        }

        .action-link.edit { color: #667eea; }
        .action-link.delete { color: #ff6b6b; }

        .action-link:hover { text-decoration: underline; }

        .form-group {
            margin-bottom: 16px;
        }

        .form-group label {
            display: block;
            color: #333;
            font-weight: 600;
            margin-bottom: 6px;
            font-size: 14px;
        }

        .form-group input {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #d8d8d8;
            border-radius: 6px;
            font-size: 14px;
        }

        .form-group input:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 2px rgba(102, 126, 234, 0.15);
        }

        .form-actions {
            display: flex;
            gap: 10px;
            margin-top: 20px;
        }

        .form-actions .submit-btn {
            flex: 1;
            padding: 12px 20px;
        }
    </style>
</head>
<body>
    <div class="page-container">
        <%@ include file="/WEB-INF/jsp/admin/fragments/adminHeader.jspf" %>

        <div class="container">
            <a href="${pageContext.request.contextPath}/admin/home" class="back-btn">&larr; Voltar</a>

            <form class="create-form" method="POST" action="${pageContext.request.contextPath}/admin/blocos">
                <h2>Novo Bloco</h2>

                <div class="form-group">
                    <label for="name">Nome do Bloco</label>
                    <input type="text" id="name" name="name" placeholder="Ex: Bloco A" required>
                </div>

                <div class="form-group">
                    <label for="floorQuant">Quantidade de Andares</label>
                    <input type="number" id="floorQuant" name="floorQuant" placeholder="Ex: 5" min="1" required>
                </div>

                <div class="form-group">
                    <label for="unitPerFloor">Apartamentos por Andar</label>
                    <input type="number" id="unitPerFloor" name="unitPerFloor" placeholder="Ex: 4" min="1" required>
                </div>

                <div class="form-actions">
                    <button type="submit" class="submit-btn">Cadastrar Bloco</button>
                </div>
            </form>

            <h1>Gerenciar Blocos</h1>

            <c:choose>
                <c:when test="${empty blockList}">
                    <div class="empty-message">Nenhum bloco cadastrado no sistema.</div>
                </c:when>
                <c:otherwise>
                    <table class="blocks-table">
                        <thead>
                            <tr>
                                <th>Nome do Bloco</th>
                                <th>Andares</th>
                                <th>Apartamentos por Andar</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="block" items="${blockList}">
                                <tr>
                                    <td>${block.name}</td>
                                    <td>${block.floorQuant}</td>
                                    <td>${block.unitPerFloor}</td>
                                    <td>
                                        <a href="#" class="action-link edit">Editar</a>
                                        <form style="display: inline;" method="POST" action="${pageContext.request.contextPath}/admin/blocos/apagar/${block.id}" onsubmit="return confirm('Tem certeza que deseja deletar este bloco?');">
                                            <button type="submit" class="action-link delete" style="background: none; border: none; padding: 0; font-size: inherit;">Deletar</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>

</html>
