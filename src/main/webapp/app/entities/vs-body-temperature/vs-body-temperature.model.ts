import { BaseEntity } from './../../shared';

export class VsBodyTemperature implements BaseEntity {
    constructor(
        public id?: string,
        public userid?: string,
        public celsius?: number,
        public measurmentdate?: any,
    ) {
    }
}
