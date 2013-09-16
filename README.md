shiro-el
========

EL Functions for [Apache Shiro}(http://shiro.apache.org/).

Provides the following EL function using Shiro facilities for implementation:

* hasAllRoles
* hasAnyRoles
* hasRole
* isAuthenticated
* isGuest
* isPermitted
* isPermittedAll
* isPermittedAny
* isRemembered
* isRunAs
* isUser
* lacksPermission
* lacksRole
* notAuthenticated

Example:
```
<?xml version="1.0" encoding="UTF-8"?>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:sf="http://shiro.apache.org/functions">
	
	<h:outputText render="#{sf:isPermitted('secret_test:read')}" value="Some test that requires 'secret_test:read' permission" />
	
</html>
```