<!doctype html>
    <head>
        <title>Welcome to tally-me.ca</title>
        <!-- change or write your page title with the help of title tags-->
        <link rel="stylesheet" type="text/css" href="css/home-style.css">
        <!-- connect css file with html useing link tag -->
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- link this font-awesome icon css link with html file for accessing all fornt awesome
        icon form boostrapcdn.com -->
    </head>
    <body>
        <ul>
            <!--starting ul tag to create unordered lists.-->
            <li>
                <!--The HTML li element is used to represent an item in a list. ... In menus and unordered lists-->
                <!--the a tag defines a hyperlink, which is used to link from one page to another-->
                <a href="#">
                    <!-- this anchor text for link your home to another page -->
                    <div class="icon">
                        <i class="fa fa-home" aria-hidden="true"></i><!-- this is home icon link get form fornt-awesome icon for home button -->	
                        <i class="fa fa-home" aria-hidden="true"></i><!-- copy and paste the home icon link here for hover effect -->	
                    </div>
                    <div class="name"><span data-text="Home">Home</span></div>
                    <!-- we are create first menu item name home -->
                </a>
            </li>
            <li>
                <a href="#">
                    <!-- this anchor text for link your About page to another page -->
                    <div class="icon">
                        <i class="fa fa-file" aria-hidden="true"></i><!-- this is file icon link get form fornt-awesome icon for about -->	
                        <i class="fa fa-file" aria-hidden="true"></i><!-- copy and paste the file icon link here for hover effect -->		
                    </div>
                    <div class="name"><span data-text="About">About</span></div>
                    <!-- we are create second menu item name About -->
                </a>
            </li>
            <li>
                <a href="count">
                    <!-- this anchor text for link your service page to another page -->
                    <div class="icon">
                        <i class="fa fa-cogs" aria-hidden="true"></i><!-- this is cogs icon link get form fornt-awesome iocn for service menu -->	
                        <i class="fa fa-cogs" aria-hidden="true"></i><!-- copy and paste the cogs icon link here for hover effect -->	
                    </div>
                    <div class="name"><span data-text="Count">Count</span></div>
                    <!--- we are create third menu item name services -->
                </a>
            </li>
            <li>
                <a href='<%=response.encodeURL("profile")%>'>
                    <!-- this anchor text for link your team page to another page -->
                    <div class="icon">
                        <i class="fa fa-users" aria-hidden="true"></i><!-- this is picture icon link get form fornt-awesome icon for portfolio --> 	
                        <i class="fa fa-users" aria-hidden="true"></i><!-- copy and paste the home icon link here for hover effect -->			
                    </div>
                    <div class="name"><span data-text="Profile">Profile</span></div>
                    <!-- we create first menu item name home -->
                </a>
            </li>
            <li>
                <a href="#">
                    <!-- this anchor text for link your home to another page -->
                    <div class="icon">
                        <i class="fa fa-envelope" aria-hidden="true"></i><!-- this is picture icon link get form fornt-awesome icon for portfolio --> 		
                        <i class="fa fa-envelope" aria-hidden="true"></i><!-- copy and paste the home icon link here for hover effect -->		
                    </div>
                    <div class="name"><span data-text="Contact">Contact</span></div>
                    <!-- we create first menu item name home -->
                </a>
            </li>
            <li>
                <a href="logout">
                    <!-- this anchor text for link your login page to another page -->
                    <div class="icon">
                        <i class="fa fa-sign-in" aria-hidden="true"></i><!-- this is sign in icon link get form fornt-awesome icon for Login --> 		
                        <i class="fa fa-sign-in" aria-hidden="true"></i><!-- copy and paste the sign in  icon link here for hover effect -->		
                    </div>
                    <div class="name"><span data-text="Logout">Logout</span></div>
                    <!-- we are create tenth menu item name login panel -->
                </a>
            </li>
        </ul>
    </body>
</html>