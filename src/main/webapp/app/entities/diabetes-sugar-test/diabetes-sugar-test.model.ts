import { BaseEntity } from './../../shared';

export class DiabetesSugarTest implements BaseEntity {
    constructor(
        public id?: string,
        public userid?: string,
        public result?: number,
        public measurmentdate?: any,
    ) {
    }
}
