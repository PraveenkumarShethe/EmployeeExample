INSERT INTO COMPANIES (id, company_name, email_domain) VALUES
  ('1', 'TISP', 'tsip.com'),
  ('2', 'TTDI', 'ttdi.com'),
  ('3', 'TJPA', 'tjpa.com');

INSERT INTO DEPARTMENT (id, department_name) VALUES
  ('1', 'Hardware'),
  ('2', 'it'),
  ('3', 'support');

INSERT INTO PROJECT(id, project_name, department_id) VALUES
    ('1','BMS', '1'),
    ('2','NPTE', '2'),
    ('3','HF', '3');

INSERT INTO EMPLOYEES (id, first_name, last_name, email, companies_id, department_id) VALUES
  ('1', 'Lokesh', 'Gupta', 'abc@gmail.com', '1', '1');