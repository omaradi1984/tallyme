<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome to tally-me.ca</title>
    <link rel="stylesheet" href="css/profile-style.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    </head>
    <body>
    
            <div class="main-content"id="signupContainer">
                <!-- Top navbar -->
                <nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
                  <div class="container-fluid">
                    <!-- Brand -->
                    <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="html/home.jsp">Home</a>
                    <!-- Form -->
                    <form class="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto">
                      <div class="form-group mb-0">
                        <div class="input-group input-group-alternative">
                          <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-search"></i></span>
                          </div>
                          <input class="form-control" placeholder="Search" type="text">
                        </div>
                      </div>
                    </form>
                  </div>
                </nav>
                <!-- Header -->
                <div class="header pb-8 pt-5 pt-lg-8 d-flex align-items-center" style="min-height: 600px; background-image: url(); background-size: cover; background-position: center top;">
                  <!-- Mask -->
                  <span class="mask bg-gradient-default opacity-8"></span>
                  <!-- Header container -->
                  <div class="container-fluid d-flex align-items-center">
                    <div class="row">
                      <div class="col-lg-7 col-md-10">
                        <h1 class="display-2 text-white">Hello ${user.firstName}!</h1>
                        <p class="text-white mt-0 mb-5">This is your profile page.</p>
                        <a href="#!" class="btn btn-info">Save changes</a>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- Page content -->
                <div class="container-fluid mt--7">
                  <div class="row">
                    <div class="col-xl-4 order-xl-2 mb-5 mb-xl-0">
                      <div class="card card-profile shadow">
                        <div class="row justify-content-center">
                          <div class="col-lg-3 order-lg-2">
                            <div class="card-profile-image">
                              <a href="#">
                                <img src="" class="rounded-circle">
                              </a>
                            </div>
                          </div>
                        </div>
                        <div class="card-header text-center border-0 pt-8 pt-md-4 pb-0 pb-md-4">
                          <div class="d-flex justify-content-between">
                          </div>
                        </div>
                        <div class="card-body pt-0 pt-md-4">
                          <div class="text-center">
                            <h3>
                              ${user.firstName} ${user.lastName} <span class="font-weight-light"></span>
                            </h3>
                            <div class="h5 font-weight-300">
                              <i class="ni location_pin mr-2"></i>${user.emailAddress}
                            </div>
                            <div class="h5 mt-4">
                              <i class="ni business_briefcase-24 mr-2"></i>Job title
                            </div>
                            <div>
                              <i class="ni education_hat mr-2"></i>Company
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-xl-8 order-xl-1">
                      <div class="card bg-secondary shadow">
                        <div class="card-header bg-white border-0">
                          <div class="row align-items-center">
                            <div class="col-8">
                              <h3 class="mb-0">My account</h3>
                            </div>
                            <div class="col-4 text-right">
                              <a href="#!" class="btn btn-sm btn-primary">Settings</a>
                            </div>
                          </div>
                        </div>
                        <div class="card-body">
                          <form>
                            <h6 class="heading-small text-muted mb-4">User information</h6>
                            <div class="pl-lg-4">
                              <div class="row">
                                <div class="col-lg-6">
                                  <div class="form-group focused">
                                    <label class="form-control-label" for="input-username">Username</label>
                                    <input type="text" name="username" id="input-username" class="form-control form-control-alternative" placeholder="Username" value="${user.username}">
                                  </div>
                                </div>
                                <div class="col-lg-6">
                                  <div class="form-group">
                                    <label class="form-control-label" for="input-email">Email Address</label>
                                    <input type="email" name="emailAddress" id="input-email" class="form-control form-control-alternative" placeholder="j.frank@example.com" value="${user.emailAddress}">
                                  </div>
                                </div>
                              </div>
                              <div class="row">
                                <div class="col-lg-6">
                                  <div class="form-group focused">
                                    <label class="form-control-label" for="input-first-name">First Name</label>
                                    <input type="text" name="firstName" id="input-first-name" class="form-control form-control-alternative" placeholder="First name" value="${user.firstName}">
                                  </div>
                                </div>
                                <div class="col-lg-6">
                                  <div class="form-group focused">
                                    <label class="form-control-label" for="input-last-name">Last Name</label>
                                    <input type="text" name="lastName" id="input-last-name" class="form-control form-control-alternative" placeholder="Last name" value="${user.lastName}">
                                  </div>
                                </div>
                              </div>
                            </div>
                            <hr class="my-4">
                            <!-- Address -->
                            <h6 class="heading-small text-muted mb-4">Contact information</h6>
                            <div class="pl-lg-4">
                              <div class="row">
                                <div class="col-md-12">
                                  <div class="form-group focused">
                                    <label class="form-control-label" for="input-address">Address</label>
                                    <input id="input-address" class="form-control form-control-alternative" placeholder="Home Address" value="e.g. Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09" type="text">
                                  </div>
                                </div>
                              </div>
                              <div class="row">
                                <div class="col-lg-4">
                                  <div class="form-group focused">
                                    <label class="form-control-label" for="input-city">City</label>
                                    <input type="text" id="input-city" class="form-control form-control-alternative" placeholder="City" value="e.g. New York">
                                  </div>
                                </div>
                                <div class="col-lg-4">
                                  <div class="form-group focused">
                                    <label class="form-control-label" for="input-country">Country</label>
                                    <input type="text" id="input-country" class="form-control form-control-alternative" placeholder="Country" value="e.g. United States">
                                  </div>
                                </div>
                                <div class="col-lg-4">
                                  <div class="form-group">
                                    <label class="form-control-label" for="input-country">Postal code</label>
                                    <input type="number" id="input-postal-code" class="form-control form-control-alternative" placeholder="e.g. Postal code">
                                  </div>
                                </div>
                              </div>
                            </div>
                            <hr class="my-4">
                            <!-- Description -->
                            <h6 class="heading-small text-muted mb-4">About me</h6>
                            <div class="pl-lg-4">
                              <div class="form-group focused">
                                <label>About Me</label>
                                <textarea rows="4" class="form-control form-control-alternative" placeholder="A few words about you ..."></textarea>
                              </div>
                            </div>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <footer class="footer">
                <div class="row align-items-center justify-content-xl-between">
                  <div class="col-xl-6 m-auto text-center">
                    <div class="copyright">
                      <p>Made with <a href="https://www.creative-tim.com/product/argon-dashboard" target="_blank">Argon Dashboard</a> by Omar & Bruce</p>
                    </div>
                  </div>
                </div>
              </footer>
    </body>
</html>