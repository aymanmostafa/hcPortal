import { BaseEntity } from './../../shared';

export class VsBloodPressure implements BaseEntity {
    constructor(
        public id?: string,
        public userid?: string,
        public systolic?: number,
        public diastolic?: number,
        public measurmentdate?: any,
    ) {
    }
}
