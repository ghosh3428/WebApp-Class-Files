<%@include  file="header.jsp" %>

<sql:setDataSource 
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/project?useSSL=false"
    user="root"
    password="yourpassword"
    var="con" />

<sql:query dataSource="${con}" var="i">
    Select * from BusInfo;
</sql:query>
<br/>
<div class="container">
    <div class="card">
        <div class="card-header text-center bg-primary text-white">
            <h1 class="heading">Bus List</h1>
        </div>
        <div class="card-body">
            <table class="table table-striped">
                <tr>
                    <th>Bus Number</th>
                    <th>Traveller Name</th>
                    <th>Source</th>
                    <th>Destination</th>
                    <th></th>
                </tr>
                <c:forEach items="${i.rows}" var="bus">
                    <tr>
                        <td>${bus.bus_number}</td>
                        <td>${bus.traveller_name}</td>
                        <td>${bus.source_station}</td>
                        <td>${bus.destination_station}</td>
                        <td> <a href="viewbus?id=${bus.id}">View</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>


</body>
</html>
