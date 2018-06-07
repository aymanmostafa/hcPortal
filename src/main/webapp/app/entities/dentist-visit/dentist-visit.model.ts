import { BaseEntity } from './../../shared';

export class DentistVisit implements BaseEntity {
    constructor(
        public id?: string,
        public userid?: string,
        public teethcleaning?: boolean,
        public whitening?: boolean,
        public restoration?: boolean,
        public crowns?: boolean,
        public bridges?: boolean,
        public braces?: boolean,
        public endodontictherapy?: boolean,
        public periodontaltherapy?: boolean,
        public extraction?: boolean,
        public oralsurgery?: boolean,
        public notes?: string,
        public measurmentdate?: any,
    ) {
        this.teethcleaning = false;
        this.whitening = false;
        this.restoration = false;
        this.crowns = false;
        this.bridges = false;
        this.braces = false;
        this.endodontictherapy = false;
        this.periodontaltherapy = false;
        this.extraction = false;
        this.oralsurgery = false;
    }
}
