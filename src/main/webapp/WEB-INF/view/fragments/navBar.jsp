<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="<spring:url value="/main"/>">Main Page</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<spring:url value="/registration/processRegistration"/>">registration</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<spring:url value="/personal_setting"/>">Personal Settings</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<spring:url value="/updateUser/processUpdate"/>">Update</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<spring:url value="/login"/>">login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="logout">logout</a>
          </li>
       
      </ul>
     
    </div>
  </div>
</nav>