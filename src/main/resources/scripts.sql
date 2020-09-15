select
	co.id_company,
	co.fantasy_name,
	co.cnpj,
	ve.id_vehicle,
	ve.rntrc,
	vt.name,
	vt.manufacturer,
	vt.model,
	vt.num_seats,
	vt.seats_type
from company as co
inner join vehicle as ve on co.id_company = ve.id_vehicle
inner join vehicle_type as vt on ve.id_vehicle = vt.id_vehicle_type
where co.cnpj = '31261251000153'

select
	pe.id_person,
	co.id_company,
	co.fantasy_name,
	ho.id_hosting,
	ho.address,
	ho.city,
	ho.complement,
	ho.features_hosting,
	ho.neighborhood,
	ho.number,
	ho.state,
	ho.tourism_regis,
	ho.zip_code
from person as pe
inner join company as co on pe.id_person = co.id_person
inner join hosting as ho on co.id_company = ho.id_hosting
where pe.id_person = 1

select
	pe.id_person,
	ad.additional,
	ad.adress,
	ad.city,
	ad.neighborhood,
	ad.number,
	ad.state,
	ad.zip_code,
	co.cell_phone,
	co.email,
	co.phone,
	il.cpf,
	il.birth_date,
	il.last_name,
	il.name,
	il.rg,
	ptc.contracted_passenger,
	ptc.paying_passenger,
	tc.boarding_time,
	tc.boarding_location,
	tc.issue_date,
	tc.total_contract_amount

from person as pe
inner join adress as ad on pe.id_person = ad.id_person
inner join contact as co on pe.id_person = co.id_person
inner join individual as il on pe.id_person = il.id_person
inner join passenger_travel_contract as ptc on il.id_individual = ptc.id_individual
inner join travel_contract as tc on ptc.id_travel_contract = tc.id_travel_contract
where il.cpf = '11867136903'