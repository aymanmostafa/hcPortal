/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { DentistVisitComponent } from '../../../../../../main/webapp/app/entities/dentist-visit/dentist-visit.component';
import { DentistVisitService } from '../../../../../../main/webapp/app/entities/dentist-visit/dentist-visit.service';
import { DentistVisit } from '../../../../../../main/webapp/app/entities/dentist-visit/dentist-visit.model';

describe('Component Tests', () => {

    describe('DentistVisit Management Component', () => {
        let comp: DentistVisitComponent;
        let fixture: ComponentFixture<DentistVisitComponent>;
        let service: DentistVisitService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [DentistVisitComponent],
                providers: [
                    DentistVisitService
                ]
            })
            .overrideTemplate(DentistVisitComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DentistVisitComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DentistVisitService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new DentistVisit('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.dentistVisits[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
