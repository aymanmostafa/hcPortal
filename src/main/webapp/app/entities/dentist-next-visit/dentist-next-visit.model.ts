import { BaseEntity } from './../../shared';

export class DentistNextVisit implements BaseEntity {
    constructor(
        public id?: string,
        public userid?: string,
        public measurmentdate?: any,
    ) {
    }
}
