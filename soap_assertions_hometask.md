### Step 1

- Create project and private repository on github with name soapUI-homework (check readme for initial commit) and clone it
- Add giorgigvalia <giorgi.gvalia123456789@gmail.com> as collaborator

### Step 2

- Create branch soapui-assertions and make following changes in this branch

### Step 3 

Build automation test in IntelliJ IDEA

- Create new project in Soap UI
- Add wsdl http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL
- Create test suite and test case
- Add 'Soap Request' test step ListOfCountryNamesByCode
- Write a test that does the following:
	- Add Xpath Assertion and validate count of all 'm:sName' node 
	- Add Script Assertion and validate 'm:sName' node result with value of m:sISOCode equals to 'GN'
          - Example of extracting node value : def result= context.expand('${Add#Response#//*:AddResult}')
        - Add XQuery Assertion and return all 'm:sName' starting with 'G'
        - Add Security assertion with valid result

### Step 4

Commit the final version and make a pull request on main.

**For homework** 
- Add giorgigvalia <giorgi.gvalia123456789@gmail.com> as reviewer
SelenideHomeWork.md
Displaying SelenideHomeWork.md.