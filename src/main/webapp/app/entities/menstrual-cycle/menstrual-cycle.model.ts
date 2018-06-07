import { BaseEntity } from './../../shared';

export class MenstrualCycle implements BaseEntity {
    constructor(
        public id?: string,
        public userid?: string,
        public startDate?: any,
        public endDate?: any,
    ) {
    }
}
