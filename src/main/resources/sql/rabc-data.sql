USE springtest;

/*Data for the table `permission` */

insert  into `permission`(`id`,`permission_name`,`permission_code`) values (1,'ViewUser','USER_VIEW'),(2,'ModifyUser','USER_ADD');


/*Data for the table `role` */

insert  into `role`(`id`,`role_name`) values (1,'Admin');


/*Data for the table `role_permission` */

insert  into `role_permission`(`id`,`role_id`,`permission_id`) values (1,1,1);


/*Data for the table `rbac_user` */

insert  into `rbac_user`(`id`,`username`,`password`,`locked`) values (1,'lan','123456',0);

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`) values (1,1,1);