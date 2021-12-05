### Step 1

- Create branch soapui-parametrization  in soapUI-homework repository 

### Step 2 

Update TestCase 2 in project https://gitlab.com/alinatkabladze/soapuiproject/-/tree/master

- Create database and table with values

create database countries;

use countries;
create table iso (
   id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
   country varchar(50),
   isoCode varchar(50),
   name varchar(50),
);

insert into iso values ( 'RU', 'RUB' ,'Rubles');
insert into iso values ('GE', 'GEL', 'Lari');

- Define JDBC driver and connection string property at Project Level (connection String - jdbc:sqlserver://localhost;username=TestAutomation;password=TestAutomation123)
- Check with Script Assertion that isoCode from database equals to m:sISOCode node value in CountryCurrency Response
- Check with Script Assertion that name from database equals to m:sName node value in CountryCurrency Response

### Step 3

Commit the final version and make a pull request on main.

**For homework** 
- Add giorgigvalia <giorgi.gvalia123456789@gmail.com> as reviewer



