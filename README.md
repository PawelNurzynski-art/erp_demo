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

Problems with GoodStorage:
<ul>
<li>post: when adding good to storage: "quantity": 99.99, in database it is saved as 1.0</li>
<li>put: when updating good in storage, the value is correct</li>
</ul>

Added file with collection in Postman: erp_demo.postman_collection.json.

Next to do:
<ul>
<li>Invoices</li>
</ul>


<!--
Doesn't work:
<ul>
<li>@PostMapping("")</li>
<li>@DeleteMapping("/delete/{contractorId}")</li>
<li>@PutMapping("/update/{contractorId}")</li>
</ul>
-->