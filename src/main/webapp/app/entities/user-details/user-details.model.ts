import { BaseEntity } from './../../shared';

export const enum Gender {
    'MALE',
    'FEMALE'
}

export const enum Ethnicity {
    'EUROPEAN',
    'MAORI',
    'PACIFIC_PEOPLES',
    'ASIAN',
    'MIDDLE_EASTERN',
    'LATIN_AMERICAN',
    'AFRICAN',
    'OTHER_ETHNICITY',
    'RESIDUAL_CATEGORIES'
}

export class UserDetails implements BaseEntity {
    constructor(
        public id?: string,
        public userid?: number,
        public activationkey?: string,
        public resetkey?: string,
        public gender?: Gender,
        public birthdate?: any,
        public ethnicity?: Ethnicity,
        public maritalStatus?: string,
        public isDoctor?: boolean,
        public resetdate?: any,
    ) {
        this.isDoctor = false;
    }
}
