/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     05/01/2022 18:28:13                          */
/*==============================================================*/


drop table CANDIDAT;

drop table CENTRE_VOTE;

drop table ELECTION;

drop table PERSONNE;

/*==============================================================*/
/* Table: CANDIDAT                                              */
/*==============================================================*/
create table CANDIDAT (
   PARTIE               VARCHAR(100)         not null,
   ANNEE                DATE                 not null,
   ID_POSTE             VARCHAR(5)           not null,
   NOM_CANDIDAT         VARCHAR(32)          null,
   AGE_CANDIDAT         INT4                 null,
   AVOIR                MONEY                null,
   SOMME_DEPOSE         MONEY                null,
   constraint PK_CANDIDAT primary key (PARTIE)
);

/*==============================================================*/
/* Table: CENTRE_VOTE                                           */
/*==============================================================*/
create table CENTRE_VOTE (
   ID_POSTE             VARCHAR(5)           not null,
   ID                   VARCHAR(5)           null,
   NOM_POSTE            VARCHAR(10)          null,
   VILLE                VARCHAR(10)          null,
   constraint PK_CENTRE_VOTE primary key (ID_POSTE)
);

/*==============================================================*/
/* Table: ELECTION                                              */
/*==============================================================*/
create table ELECTION (
   ANNEE                DATE                 not null,
   ID                   VARCHAR(5)           not null,
   NOM_GAGNANT          VARCHAR(32)          null,
   POURCENTAGE          FLOAT8               null,
   POUR_PARTICIPANT     FLOAT8               null,
   constraint PK_ELECTION primary key (ANNEE)
);

/*==============================================================*/
/* Table: PERSONNE                                              */
/*==============================================================*/
create table PERSONNE (
   ID                   VARCHAR(5)           not null,
   NOM_PERSONNE         VARCHAR(32)          null,
   MOT_DE_PASSE         VARCHAR(5)           null,
   NUM_CNI              VARCHAR(17)          null,
   STATUE               BOOL                 null,
   AGE                  INT4                 null,
   constraint PK_PERSONNE primary key (ID)
);

alter table CANDIDAT
   add constraint FK_CANDIDAT_CHOISIR_CENTRE_V foreign key (ID_POSTE)
      references CENTRE_VOTE (ID_POSTE)
      on delete restrict on update restrict;

alter table CANDIDAT
   add constraint FK_CANDIDAT_GAGNE_ELECTION foreign key (ANNEE)
      references ELECTION (ANNEE)
      on delete restrict on update restrict;

alter table CENTRE_VOTE
   add constraint FK_CENTRE_V_RENDRE_PERSONNE foreign key (ID)
      references PERSONNE (ID)
      on delete restrict on update restrict;

alter table ELECTION
   add constraint FK_ELECTION_PARTICIPE_PERSONNE foreign key (ID)
      references PERSONNE (ID)
      on delete restrict on update restrict;

