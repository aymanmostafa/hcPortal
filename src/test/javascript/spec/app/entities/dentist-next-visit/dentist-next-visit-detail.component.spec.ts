/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { HcPortalTestModule } from '../../../test.module';
import { DentistNextVisitDetailComponent } from '../../../../../../main/webapp/app/entities/dentist-next-visit/dentist-next-visit-detail.component';
import { DentistNextVisitService } from '../../../../../../main/webapp/app/entities/dentist-next-visit/dentist-next-visit.service';
import { DentistNextVisit } from '../../../../../../main/webapp/app/entities/dentist-next-visit/dentist-next-visit.model';

describe('Component Tests', () => {

    describe('DentistNextVisit Management Detail Component', () => {
        let comp: DentistNextVisitDetailComponent;
        let fixture: ComponentFixture<DentistNextVisitDetailComponent>;
        let service: DentistNextVisitService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [DentistNextVisitDetailComponent],
                providers: [
                    DentistNextVisitService
                ]
            })
            .overrideTemplate(DentistNextVisitDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DentistNextVisitDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DentistNextVisitService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new DentistNextVisit('123')
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith('123');
                expect(comp.dentistNextVisit).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
