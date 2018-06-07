/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { HcPortalTestModule } from '../../../test.module';
import { DentistVisitDetailComponent } from '../../../../../../main/webapp/app/entities/dentist-visit/dentist-visit-detail.component';
import { DentistVisitService } from '../../../../../../main/webapp/app/entities/dentist-visit/dentist-visit.service';
import { DentistVisit } from '../../../../../../main/webapp/app/entities/dentist-visit/dentist-visit.model';

describe('Component Tests', () => {

    describe('DentistVisit Management Detail Component', () => {
        let comp: DentistVisitDetailComponent;
        let fixture: ComponentFixture<DentistVisitDetailComponent>;
        let service: DentistVisitService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [DentistVisitDetailComponent],
                providers: [
                    DentistVisitService
                ]
            })
            .overrideTemplate(DentistVisitDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DentistVisitDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DentistVisitService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new DentistVisit('123')
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith('123');
                expect(comp.dentistVisit).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
