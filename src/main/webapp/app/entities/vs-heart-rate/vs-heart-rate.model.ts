import { BaseEntity } from './../../shared';

export class VsHeartRate implements BaseEntity {
    constructor(
        public id?: string,
        public userid?: string,
        public bpm?: number,
        public measurmentdate?: any,
    ) {
    }
}
