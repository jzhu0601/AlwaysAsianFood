<!DOCTYPE html>
<html ng-app="asianFoodApp">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Always Asian Food</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css"/>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.15/angular-ui-router.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/js/controllers.js"></script>
</head>


<body ng-controller="homeCtrl">

<nav class="navbar navbar-inverse">
    <div class="container">
        <a class="navbar-brand" data-ui-sref="home">Always Asian Food</a>

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a>Restaurant List</a></li>
                <li><a><i class="glyphicon glyphicon-plus"></i>Add
                    Restaurant</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div style="padding-top: 200px">
        <div style="padding: 0px 0px 20px 30px">
            <form class="form-horizontal" role="form" method="post" action="#">
                <div class="form-group">
                    <label class="col-md-2 control-label">Search Restaurant:</label>

                    <div class="col-md-5">
                        <input type="text" class="form-control" name="restaurantName"
                               ng-model="restaurantName" placeholder="Type restaurant name here"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>	