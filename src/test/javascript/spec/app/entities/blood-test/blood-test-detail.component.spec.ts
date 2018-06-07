/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { HcPortalTestModule } from '../../../test.module';
import { BloodTestDetailComponent } from '../../../../../../main/webapp/app/entities/blood-test/blood-test-detail.component';
import { BloodTestService } from '../../../../../../main/webapp/app/entities/blood-test/blood-test.service';
import { BloodTest } from '../../../../../../main/webapp/app/entities/blood-test/blood-test.model';

describe('Component Tests', () => {

    describe('BloodTest Management Detail Component', () => {
        let comp: BloodTestDetailComponent;
        let fixture: ComponentFixture<BloodTestDetailComponent>;
        let service: BloodTestService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [BloodTestDetailComponent],
                providers: [
                    BloodTestService
                ]
            })
            .overrideTemplate(BloodTestDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(BloodTestDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BloodTestService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new BloodTest('123')
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith('123');
                expect(comp.bloodTest).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
