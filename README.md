ERP DEMO

Reorganized packages to:
<ul>
<li>controller</li>
<li>entity</li>
<li>repository</li>
</ul>

Added:
<ul>
<li>GoodStorageController</li>
<li>GoodSorageEntity</li>
<li>GoodStorageRepository</li>
</ul>


File with collection in Postman: erp_demo.postman_collection.json.

Next to do:
<ul>
<li>Invoices</li>
<li>addition of mappers (MapStruct)</li>
<li>changing paths</li>
<li>adding enum to definitionState</li>
<li>changing id to UUID</li>
<li>changing primitives to objects in object fields</li>
<li>return object in update operation</li>
<li>correct response codes in case of errors</li>
<li>addition of lombok</li>
<li>adding relationships between id of individual entities</li>
<li>liquibase scripts to load the database with data (developer profile)</li>
<li>unit tests</li>
<li>change of date from String to LocalDate</li>
</ul>


<!--

Problems with GoodStorage:
<ul>
<li>post: when adding good to storage: "quantity": 99.99, in database it is saved as 1.0</li>
<li>put: when updating good in storage, the value is correct</li>
</ul>



Doesn't work:
<ul>
<li>@PostMapping("")</li>
<li>@DeleteMapping("/delete/{contractorId}")</li>
<li>@PutMapping("/update/{contractorId}")</li>
</ul>
-->