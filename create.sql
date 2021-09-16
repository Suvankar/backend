create table fileupload.filedetails (uid varchar(255) not null, file_name varchar(255), file_type varchar(255), summary varchar(255), uploaded_by varchar(255), primary key (uid))
create table fileupload.file_details_custom_tags (file_details_uid varchar(255) not null, custom_tags varchar(255))
create table fileupload.file_details_eval_tags (file_details_uid varchar(255) not null, eval_tags varchar(255))
create table fileupload.file_details_related_files (file_details_uid varchar(255) not null, related_files varchar(255))
alter table fileupload.file_details_custom_tags add constraint FKr1v7kca9o51owbm7etp8s2gcv foreign key (file_details_uid) references fileupload.filedetails
alter table fileupload.file_details_eval_tags add constraint FK6bdje79rpknekwiqjsgtdfcnq foreign key (file_details_uid) references fileupload.filedetails
alter table fileupload.file_details_related_files add constraint FKdcganxo5otfpxioan6srqscc foreign key (file_details_uid) references fileupload.filedetails
