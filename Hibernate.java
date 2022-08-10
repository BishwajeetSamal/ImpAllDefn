Hibernate is an ORM framework.

Commonly use hibernate annotations
-----------------------------------
*@Entity->use to mark any class as Entity.
*@Table->use to change the table details.
*@Id->use to mark column as id(primary key)
*@GeneratedValue->hibernate will automatically generate values for that using an internal sequence. Therefore,
we don't have to set manually.
*@GeneratedValue(strategy= ), need to provide the strategy for auto increment. 
*@Column ->Can be used to specify column mappings. For Example, to change the column name in the associated 
table in database.
*@Transient->This tells hibernate not to save the field.
*@Temporal->@Temporal over a date field tells hibernate the format in which the date needs to be saved.
*@Lob->@Lob tells hibernate that this is a large object, not a simple object.(BLOB, CLOB etc.)