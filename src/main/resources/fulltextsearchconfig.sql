alter table products
add column document_with_weights tsvector;
update products
set document_with_weights = setweight(to_tsvector(coalesce(general_description, '')), 'A') || setweight(to_tsvector(coalesce(technical_description, '')), 'B');

create index document_weights_idx
on products
using gin (document_with_weights);

create function product_tsvector_trigger() returns trigger as $$
begin
	new.document_with_weights:=
	setweight(to_tsvector('english', coalesce(new.general_description, '')), 'A') ||
	setweight(to_tsvector('english', coalesce(new.technical_description, '')), 'B');
	return new;

end
$$ language plpgsql;

create trigger tsvectorupdate before insert or update
on PRODUCTS for each row execute procedure product_tsvector_trigger();
