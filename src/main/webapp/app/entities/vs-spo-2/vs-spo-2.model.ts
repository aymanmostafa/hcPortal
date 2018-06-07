import { BaseEntity } from './../../shared';

export class VsSpo2 implements BaseEntity {
    constructor(
        public id?: string,
        public userid?: string,
        public percent?: number,
        public measurmentdate?: any,
    ) {
    }
}
