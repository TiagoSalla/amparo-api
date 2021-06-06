CREATE TABLE ADDRESS
(
    ADDRESS_ID      bigserial    NOT NULL,
    STREET_NAME     varchar(255) NOT NULL,
    DISTRICT        varchar(255) NOT NULL,
    NUMBER          integer      NOT NULL,
    COMPLEMENT      varchar(255) NULL,
    ZIP_CODE        varchar(9)   NOT NULL,
    CITY_NAME       varchar(255) NOT NULL,
    FEDERATIVE_UNIT varchar(2)   NOT NULL,
    CREATED_AT      timestamp    NOT NULL,
    UPDATED_AT      timestamp    NOT NULL,

    CONSTRAINT address_pk PRIMARY KEY (address_id)
);

CREATE TABLE DOSAGE
(
    DOSAGE_ID            bigserial    NOT NULL,
    QUANTITY             integer      NOT NULL,
    QUANTITY_TYPE        varchar(255) NOT NULL,
    FREQUENCY            integer      NOT NULL,
    FREQUENCY_TYPE       varchar(255) NOT NULL,
    ADMINISTRATION_ROUTE varchar(255) NOT NULL,
    CREATED_AT           timestamp    NOT NULL,
    UPDATED_AT           timestamp    NOT NULL,

    CONSTRAINT dosage_pk PRIMARY KEY (dosage_id)
);

CREATE TABLE HEALTH_INSURANCE
(
    HEALTH_INSURANCE_ID   bigserial    NOT NULL,
    HEALTH_INSURANCE_TYPE varchar(255) NOT NULL,
    INSCRIPTION           integer      NOT NULL,
    OBSERVATION           varchar(255) NULL,
    CREATED_AT            timestamp    NOT NULL,
    UPDATED_AT            timestamp    NOT NULL,

    CONSTRAINT health_insurance_pk PRIMARY KEY (health_insurance_id)
);

CREATE TABLE MEDICINE
(
    MEDICINE_ID   bigserial    NOT NULL,
    NAME          varchar(255) NOT NULL,
    LABORATORY    varchar(255) NOT NULL,
    DUE_DATE      timestamp    NOT NULL,
    STATUS_ACTIVE boolean      NOT NULL,
    DOSAGE_ID     bigserial    NOT NULL,
    CREATED_AT    timestamp    NOT NULL,
    UPDATED_AT    timestamp    NOT NULL,

    CONSTRAINT medicine_pk PRIMARY KEY (medicine_id),
    CONSTRAINT medicine_dosage_fk FOREIGN KEY (dosage_id) REFERENCES DOSAGE (dosage_id)
);

CREATE TABLE PROFESSIONAL
(
    PROFESSIONAL_ID        bigserial    NOT NULL,
    NAME                   varchar(255) NOT NULL,
    NICKNAME               varchar(255) NULL,
    SOCIAL_NAME            varchar(255) NOT NULL,
    USERNAME               varchar(255) NOT NULL,
    PASSWORD               varchar(255) NOT NULL,
    PROFESSIONAL_SPECIALTY varchar(255) NOT NULL,
    REGISTER               varchar(255) NOT NULL,
    CPF                    varchar(14)  NOT NULL,
    RG                     varchar(12)  NOT NULL,
    BIRTH_DATE             timestamp    NOT NULL,
    RACE                   varchar(10)  NOT NULL,
    GENDER                 varchar(6)   NOT NULL,
    MARITAL_STATUS         varchar(9)   NOT NULL,
    ADDRESS_ID             bigserial    NOT NULL,
    EMAIL                  varchar(255) NOT NULL,
    MOBILE_PHONE           varchar(255) NOT NULL,
    RESIDENTIAL_PHONE      varchar(255) NULL,
    CREATED_AT             timestamp    NOT NULL,
    UPDATED_AT             timestamp    NOT NULL,

    CONSTRAINT professional_pk PRIMARY KEY (professional_id),
    CONSTRAINT professional_address_fk FOREIGN KEY (address_id) REFERENCES ADDRESS (address_id)
);

CREATE TABLE RESIDENT
(
    RESIDENT_ID         bigserial    NOT NULL,
    NAME                varchar(255) NOT NULL,
    SOCIAL_NAME         varchar(255) NULL,
    NICKNAME            varchar(255) NULL,
    CPF                 varchar(14)  NOT NULL,
    RG                  varchar(12)  NOT NULL,
    RACE                varchar(10)  NOT NULL,
    GENDER              varchar(6)   NOT NULL,
    MARITAL_STATUS      varchar(9)   NOT NULL,
    BIRTH_DATE          timestamp    NOT NULL,
    HEALTH_INSURANCE_ID bigserial    NOT NULL,
    CREATED_AT          timestamp    NOT NULL,
    UPDATED_AT          timestamp    NOT NULL,

    CONSTRAINT resident_pk PRIMARY KEY (resident_id),
    CONSTRAINT resident_health_insurance_fk FOREIGN KEY (health_insurance_id) REFERENCES HEALTH_INSURANCE (health_insurance_id)
);

CREATE TABLE RESPONSIBLE
(
    RESPONSIBLE_ID    bigserial    NOT NULL,
    NAME              varchar(255) NOT NULL,
    SOCIAL_NAME       varchar(255) NULL,
    CPF               varchar(14)  NOT NULL,
    RG                varchar(12)  NOT NULL,
    ADDRESS_ID        bigserial    NOT NULL,
    EMAIL             varchar(255) NOT NULL,
    MOBILE_PHONE      varchar(255) NOT NULL,
    RESIDENTIAL_PHONE varchar(255) NULL,
    RESIDENT_ID       bigserial    NOT NULL,
    CREATED_AT        timestamp    NOT NULL,
    UPDATED_AT        timestamp    NOT NULL,

    CONSTRAINT responsible_pk PRIMARY KEY (responsible_id),
    CONSTRAINT responsible_address_fk FOREIGN KEY (address_id) REFERENCES ADDRESS (address_id),
    CONSTRAINT responsible_resident_fk FOREIGN KEY (resident_id) REFERENCES RESIDENT (resident_id)
);

CREATE TABLE TREATMENT
(
    TREATMENT_ID    bigserial NOT NULL,
    RESIDENT_ID     bigserial NOT NULL,
    PROFESSIONAL_ID bigserial NOT NULL,
    CREATED_AT      timestamp NOT NULL,
    UPDATED_AT      timestamp NOT NULL,

    CONSTRAINT treatment_pk PRIMARY KEY (treatment_id),
    CONSTRAINT treatment_resident_fk FOREIGN KEY (resident_id) REFERENCES RESIDENT (resident_id),
    CONSTRAINT treatment_professional_fk FOREIGN KEY (professional_id) REFERENCES PROFESSIONAL (professional_id)
);

CREATE TABLE MEDICINE_TREATMENT
(
    TREATMENT_ID bigserial NOT NULL,
    MEDICINE_ID  bigserial NOT NULL,

    CONSTRAINT medicine_treatment_medicine_fk FOREIGN KEY (medicine_id) REFERENCES MEDICINE (medicine_id),
    CONSTRAINT medicine_treatment_treatment_fk FOREIGN KEY (treatment_id) REFERENCES TREATMENT (treatment_id)
);