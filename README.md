ERP DEMO

Reorganized packages to:
<ul>
<li>controller</li>
<li>dto</li>
<li>entity</li>
<li>repository</li>
</ul>

Changed schema:
<ul>
<li>Counterparty</li>
<li>Product</li>
<li>Item</li>
<li>Invoice</li>
</ul>

File with collection in Postman: erp_demo.postman_collection.json.

Next to do:
<ul>
<li>addition of mappers (MapStruct)</li>
<li>adding enum to definitionState</li>
<li>return object in update operation</li>
<li>correct response codes in case of errors</li>
<li>addition of lombok</li>
<li>liquibase scripts to load the database with data (developer profile)</li>
<li>unit tests</li>
</ul>




<!--
Problem with InvoiceController:
<ul>
<li>put: update invoice in database, but doesn't return JSON</li>
<li>ERROR:<br>
2023-01-18T19:23:13.075+01:00 ERROR 12851 --- [nio-8080-exec-3] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor]] with root cause
</li>
</ul>
The same problem is with CUrrencyController.
-->


<!--
Doesn't work:
<ul>
<li>@PostMapping("")</li>
<li>@DeleteMapping("/delete/{contractorId}")</li>
<li>@PutMapping("/update/{contractorId}")</li>
</ul>
-->