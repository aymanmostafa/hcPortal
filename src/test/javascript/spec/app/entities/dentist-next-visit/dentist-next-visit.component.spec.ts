/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { DentistNextVisitComponent } from '../../../../../../main/webapp/app/entities/dentist-next-visit/dentist-next-visit.component';
import { DentistNextVisitService } from '../../../../../../main/webapp/app/entities/dentist-next-visit/dentist-next-visit.service';
import { DentistNextVisit } from '../../../../../../main/webapp/app/entities/dentist-next-visit/dentist-next-visit.model';

describe('Component Tests', () => {

    describe('DentistNextVisit Management Component', () => {
        let comp: DentistNextVisitComponent;
        let fixture: ComponentFixture<DentistNextVisitComponent>;
        let service: DentistNextVisitService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [DentistNextVisitComponent],
                providers: [
                    DentistNextVisitService
                ]
            })
            .overrideTemplate(DentistNextVisitComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DentistNextVisitComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DentistNextVisitService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new DentistNextVisit('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.dentistNextVisits[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
