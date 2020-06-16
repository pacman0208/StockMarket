# StockMarket
> This project is for Stackthon practise purpose.

<ul>
    <li>Folder WireFrame_Design is storing the front end design.</li>
    <li>
        Folder frontEnd is the front end code implemented by Angular version 9.
        <p> After running the application,Using http://localhost:4200/user you can use username 'test',and password '111' to login to the User system.</p>
        <p>Uing the URL http://localhost:4200/admin/login You can use username 'admin',and password '111' to login to the system.</p>
    </li>
    <li>
        Folder backEnd is storing backend services based on micro service architecture and implemented by Spring Cloud tech . And using IdeaIntelliJ as the IDE to build up the project.
        <p>common module is used for common class and methods.</p>
        <p>EurekaServerService is created for registry and discovery purpose in the micro service.</p>
        <p>ZuulService is used as the API gateway in the micro service.</p>
        <p>StockService is used for stock/company related services.</p>
        <p>UserService is used for user related services.</p>
    </li>
</ul>



