-- Select de Empresas e seus Veiculos
SELECT
	co.id_company,
	co.fantasy_name,
	co.cnpj,
	ve.id_vehicle,
	ve.rntrc,
	vt.name_vehicle_type,
	vt.manufacturer,
	vt.model,
	vt.num_seats,
	vt.seats_type
FROM company AS co
INNER JOIN vehicle AS ve ON co.id_company = ve.id_vehicle
INNER JOIN vehicle_type AS vt ON ve.id_vehicle = vt.id_vehicle_type
WHERE co.cnpj = '31261251000153';

--Select de Empresas e suas hospedagens
SELECT
	pe.id_person,
	co.id_company,
	co.fantasy_name,
	ho.id_hosting,
	ho.tourism_regis,
	ad.adress,
	ad.city,
	ad.additional,
	ad.neighborhood,
	ad.adress_number,
	ad.state,
	ad.zip_code
FROM person AS pe
INNER JOIN adress as ad ON pe.id_person = ad.id_person
INNER JOIN company AS co ON pe.id_person = co.id_person
INNER JOIN hosting AS ho ON co.id_company = ho.id_hosting
WHERE pe.id_person = 1;

--Select de contrato de um passageiro
SELECT
	pe.id_person,
	ad.additional,
	ad.adress,
	ad.city,
	ad.neighborhood,
	ad.adress_number,
	ad.state,
	ad.zip_code,
	co.cell_phone,
	co.email,
	co.phone,
	il.cpf,
	il.birth_date,
	il.last_name,
	il.name_individual,
	il.rg,
	ptc.contracted_passenger,
	ptc.paying_passenger,
	tc.boarding_time,
	tc.boarding_location,
	tc.issue_date,
	tc.total_contract_amount
FROM person AS pe
INNER JOIN adress AS ad ON pe.id_person = ad.id_person
INNER JOIN contact AS co ON pe.id_person = co.id_person
INNER JOIN individual AS il ON pe.id_person = il.id_person
INNER JOIN passenger_travel_contract AS ptc ON il.id_individual = ptc.id_individual
INNER JOIN travel_contract AS tc ON ptc.id_travel_contract = tc.id_travel_contract
WHERE il.cpf = '11867136903';
